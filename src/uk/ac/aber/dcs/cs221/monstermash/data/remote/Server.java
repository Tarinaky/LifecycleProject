package uk.ac.aber.dcs.cs221.monstermash.data.remote;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class Server {

	private volatile String httpAddress="NoName";
	private volatile String serverName="NoAddress";
	
	private volatile Client client;
	private final static String userLookup = "/users?userID=";
	
	public Server() {
		client = new Client();
	}
	
	
	public synchronized Server readJSON(JSONObject json) throws JSONException {
		serverName = "Group"+json.getInt("serverNumber");
		httpAddress = json.getString("httpRoot");
		return this;		
	}

	public synchronized String getName() {
		return serverName;
	}
	
	public synchronized String getAddress() {
		return httpAddress;
	}
	
	
	public synchronized RemoteUser lookup(String uid) throws UniformInterfaceException, ClientHandlerException, JSONException {
		WebResource r = client.resource(getAddress() + userLookup +uid);
		JSONObject json = new JSONObject(r.get(String.class) );
		RemoteUser user = new RemoteUser().readJSON(json);
		return user;
	}

}
