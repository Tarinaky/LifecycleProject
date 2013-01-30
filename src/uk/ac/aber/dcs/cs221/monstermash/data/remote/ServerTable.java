package uk.ac.aber.dcs.cs221.monstermash.data.remote;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class ServerTable {
	private final static String directory = "http://monstermash.digitdex.com/directory/all"; 
	
	private volatile java.util.HashMap<String,Server> servers;
	
	public ServerTable() {
		servers = new java.util.HashMap<String,Server>();
	}
	
	public synchronized Server lookup(String name) {
		return servers.get(name);
	}
	
	public synchronized ServerTable readJSON(JSONArray json) throws JSONException {
		for (int i = 0; i < json.length(); ++i) {
			Server server = new Server();
			server.readJSON(json.getJSONObject(i));
			servers.put(server.getName(), server);
		}
		
		return this;
	}
	
	public synchronized ServerTable load() throws UniformInterfaceException, ClientHandlerException, JSONException {
		Client client = new Client();
		WebResource r = client.resource(directory);
		JSONArray json = new JSONArray(r.get(String.class) );
		this.readJSON(json);
		
		return this;
	}
	

}
