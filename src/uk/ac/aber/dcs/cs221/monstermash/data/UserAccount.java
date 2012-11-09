package uk.ac.aber.dcs.cs221.monstermash.data;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * The data associated with a single user.
 * @author Jacob Smith (jas32)
 *
 */
public class UserAccount extends java.util.Observable {
	private volatile long primaryKey;
	private volatile String email;
	
	private volatile String password;
	private volatile TreeSet<Monster> monsters;
		
	/**
	 * Compare a given string with the password on file.
	 * @param password The string to check.
	 * @return True iff this is the correct password for this user.
	 */
	
	public long getUID() { return primaryKey; }
	
	public boolean checkPassword(String check){
		String password = this.password;//Copy value to ensure value will not change due
		//to interleaving.
		if (password == null) { return false; } // Account locked.
		return (password.equals(password) );
	}
	
	/**
	 * Ctor
	 * @param primaryKey The primary key to permanently associate with this account.  
	 */
	public UserAccount(long primaryKey) {
		this.primaryKey = primaryKey;
		
		this.monsters = new TreeSet<Monster>();
	}
	
	/**
	 * Change this user's email account and automatically update its containing table.
	 * @param email The user's new email address.
	 * @return This UserAccount object.
	 */
	public synchronized UserAccount setEmail(String email) {
		String oldemail = this.email;
		this.email = email;
		setChanged();
		notifyObservers(oldemail);
		return this;
	}
	
	/**
	 * 
	 * @return The user's current email address.
	 */
	public String getEmail() { return email; }
	
	/**
	 * Change the user's password.
	 * @param password The user's new password.
	 * @return This UserAccount object.
	 */
	public UserAccount setPassword(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Construct a JSON dictionary representing this object.
	 * @return
	 * @throws JSONException
	 */
	public synchronized JSONObject buildJSON() throws JSONException {
		JSONObject json = new JSONObject();
		json.put("primaryKey", primaryKey);
		json.put("email", email);
		json.put("password", password);
		
		for (Monster monster: monsters) {
			json.append("monsters", monster.buildJSON() );
		}
		
		return json;
	}

	/**
	 * Deserialise the user from a JSON expression.
	 * @param json A valid JSON object.
	 * @throws JSONException
	 */
	public synchronized UserAccount readJSON(JSONObject json) throws JSONException {
		primaryKey = json.getLong("primaryKey");
		email = json.getString("email");
		password = json.getString("password");
		
		JSONArray monsters = json.optJSONArray("monsters");
		if (monsters != null) {
			for (int i = 0; i < monsters.length(); ++i) {
				this.monsters.add(Monster.readJSON(this,monsters.getJSONObject(i) ) );
			}
		}
		return this;
		
	}

	/**
	 * This method is called by  {@link Monster#setOwner(UserAccount)}.
	 * @param monster The monster to associate with this UserAccount.
	 */
	public synchronized void addMonster(Monster monster) {
		this.monsters.add(monster);
	}
	
	/**
	 * This method is called by {@link Monster#setOwner(UserAccount)} and {@link Monster#reap()}.
	 * @param monster The monster to remove from this UserAccount.
	 */
	public synchronized void removeMonster(Monster monster) {
		this.monsters.remove(monster);
	}
}

