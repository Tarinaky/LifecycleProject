package uk.ac.aber.dcs.cs221.monstermash.data.remote;

import org.json.JSONException;
import org.json.JSONObject;

import uk.ac.aber.dcs.cs221.monstermash.data.UserAccount;

public class RemoteUser extends UserAccount {
	
	public RemoteUser() {
		super(-1);
	}

	private volatile String userID = "";

	public synchronized RemoteUser readJSON(JSONObject json) throws JSONException {
		this.userID = json.getString("userID");
		this.setEmail(json.getString("name") );
		this.setCash(json.getInt("money") );
		
		return this;
	}
	
	public synchronized String getRemoteID() {
		return userID;
	}
	
	
	
	

}
