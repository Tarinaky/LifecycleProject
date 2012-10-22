package uk.ac.aber.dcs.cs221.monstermash.data;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class UserAccount extends java.util.Observable {
	private long primaryKey;
	private String email;
	
	private String password;
	private ArrayList<Object> listOfMonsters;
		
	public boolean checkPassword(String password){
		if (this.password == null) { return false; } // Account locked.
		return (this.password.equals(password) );
	}
	
	public UserAccount(long primaryKey) {
		this.primaryKey = primaryKey; // Assign next key and increment.
	}
	
	public UserAccount setEmail(String email) {
		String oldemail = this.email;
		this.email = email;
		setChanged();
		notifyObservers(oldemail);
		return this;
	}
	
	public String getEmail() { return email; }
	
	public UserAccount setPassword(String password) {
		this.password = password;
		return this;
	}

	public JSONObject buildJSON() throws JSONException {
		JSONObject json = new JSONObject();
		json.put("primaryKey", primaryKey);
		json.put("email", email);
		json.put("password", password);
		
		return json;
	}

	public void readJSON(JSONObject json) throws JSONException {
		primaryKey = json.getLong("primaryKey");
		email = json.getString("email");
		password = json.getString("password");
		
	}
}

