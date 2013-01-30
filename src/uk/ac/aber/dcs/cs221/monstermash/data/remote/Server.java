package uk.ac.aber.dcs.cs221.monstermash.data.remote;

import org.json.JSONArray;
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
	private final static String monstersByUser = "/monsters?userID=";
	
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
	
	
	public synchronized RemoteUser lookupUser(String uid) throws UniformInterfaceException, ClientHandlerException, JSONException {
		WebResource r;
		r = client.resource(getAddress() + userLookup +uid);
		JSONObject json = new JSONObject(r.get(String.class) );
		RemoteUser user = new RemoteUser().readJSON(json);
		
		//Add monsters.
		r = client.resource(getAddress() + monstersByUser + uid);
		JSONArray monsters = new JSONArray(r.get(String.class) );
		for (int i = 0; i < monsters.length(); ++i) {
			new RemoteMonster().readJSON(monsters.getJSONObject(i), user);
		}
		
		return user;
	}

}
