package uk.ac.aber.dcs.cs221.monstermash.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * This is a container for all the UserAccounts recognised by the system.
 * @author Jacob Smith (jas32)
 *
 */
public class TableOfAccounts implements Observer {
	private long nextAccountKey;
	
	
	private HashMap<String,UserAccount> accounts;

	public TableOfAccounts() {
		nextAccountKey = 1;
		accounts = new HashMap<String,UserAccount>();
	}
	
	/**
	 * Obtain a UserAccount from this table.
	 * @param email The email address to look up.
	 * @return The UserAccount if it exists or null if there is no such account.
	 */
	public UserAccount lookup(String email){
		return accounts.get(email);
	}
	
	/**
	 * Create a UserAccount and associate it with the given email address.
	 * @param email The email address to associate with the UserAccount.
	 * @return The new UserAccount or null if the email address is already in use.
	 */
	public UserAccount addUser(String email){
		if (accounts.containsKey(email) ) {
			return null;//Duplicate username.
		}
		
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
	
	/**
	 * Creates a dictionary representing the object.
	 * @return
	 * @throws JSONException
	 */
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
	
	/**
	 * Deserialises an object from a JSON expression.
	 * TODO: Allow deserialisation from a Reader object
	 * @param expression A valid JSON object.
	 * @return The deserialised object.
	 * @throws JSONException
	 */
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
