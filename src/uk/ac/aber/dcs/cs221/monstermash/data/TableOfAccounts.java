package uk.ac.aber.dcs.cs221.monstermash.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import org.json.JSONArray;
import org.json.JSONException;

public class TableOfAccounts implements Observer {
	private long nextAccountKey;
	
	
	private HashMap<String,UserAccount> accounts;

	TableOfAccounts() {
		nextAccountKey = 1;
		accounts = new HashMap<String,UserAccount>();
	}
	
	public UserAccount lookup(String email){
		return accounts.get(email);
	}
	public UserAccount addUser(String email){
		UserAccount user = new UserAccount(nextAccountKey++);
		user.setEmail(email);
		accounts.put(email, user);
		user.addObserver(this);
		return user;
	}
	@Override
	public void update(Observable user, Object oldemail) {
		accounts.remove(oldemail);
		accounts.put(((UserAccount) user).getEmail(), (UserAccount)user);
	}
	
	public org.json.JSONObject buildJSON() throws JSONException {
		org.json.JSONObject json = new org.json.JSONObject();
		//Fields
		json.put("nextAccountKey", nextAccountKey);
		
		//List of users
		for (UserAccount account: accounts.values()) {
			json.append("users",account.buildJSON() );
		}
		
		
		return json;
	}
	
	public TableOfAccounts readJSON(String expression) throws JSONException {
		org.json.JSONObject json = new org.json.JSONObject(expression);
		
		//Load primary key gen
		nextAccountKey = json.getLong("nextAccountKey");
		
		//Load users
		JSONArray array = json.getJSONArray("users");
		for (int i = 0; i < array.length(); ++i) {
			UserAccount account = new UserAccount(0);
			account.readJSON(array.getJSONObject(i));
			accounts.put(account.getEmail(), account);
			account.addObserver(this);
		}
		
		
		return this;
	}
	
	
	
}
