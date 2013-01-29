package uk.ac.aber.dcs.cs221.monstermash.data.remote;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerTable {
	private volatile java.util.HashMap<String,Server> servers;
	
	public synchronized Server lookup(String name) {
		return servers.get(name);
	}
	
	public synchronized ServerTable readJSON(JSONArray json) throws JSONException {
		for (int i = 0; i < json.length(); ++i) {
			Server server = new Server();
			server.readJSON(json.get(i));
			servers.put(server.getName(), server);
		}
		
		return this;
	}
	

}
