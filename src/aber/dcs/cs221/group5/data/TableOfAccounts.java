package aber.dcs.cs221.group5.data;

/**
 * Hashtable of users with relating methods.
 * @author Jacob Smith, jas32
 *
 */

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
	private volatile long nextAccountKey;
	private volatile HashMap<String,UserAccount> accountsByEmail;
	private volatile HashMap<Long,UserAccount> accountsByUID;

	public TableOfAccounts() {
		nextAccountKey = 1;
		accountsByEmail = new HashMap<String,UserAccount>();
		accountsByUID = new HashMap<Long,UserAccount>();
	}
	
	/**
	 * Obtain a UserAccount from this table.
	 * @param email The email address to look up.
	 * @return The UserAccount if it exists or null if there is no such account.
	 */
	public synchronized UserAccount lookup(String email){
		return accountsByEmail.get(email);
	}
	public synchronized UserAccount lookup(long uid){
		return accountsByUID.get(uid);
	}
	
	/**
	 * Create a UserAccount and associate it with the given email address.
	 * @param email The email address to associate with the UserAccount.
	 * @return The new UserAccount or null if the email address is already in use.
	 */
	public synchronized UserAccount addUser(String email){
		if (accountsByEmail.containsKey(email) ) {
			return null;//Duplicate username.
		}
		
		UserAccount user = new UserAccount(nextAccountKey++);
		user.setEmail(email);
		accountsByEmail.put(email, user);
		accountsByUID.put(user.getUID(), user);
		user.addObserver(this);
		return user;
	}
	
	@Override
	public synchronized void update(Observable user, Object oldemail) {
		accountsByEmail.remove(oldemail);
		accountsByEmail.put(((UserAccount) user).getEmail(), (UserAccount)user);
	}
	
	/**
	 * Creates a dictionary representing the object.
	 * @return
	 * @throws JSONException
	 */
	public synchronized org.json.JSONObject buildJSON() throws JSONException {
		org.json.JSONObject json = new org.json.JSONObject();
		//Fields
		json.put("nextAccountKey", nextAccountKey);
		
		//List of users
		for (UserAccount account: accountsByEmail.values()) {
			json.append("users",account.buildJSON() );
			
		}
			
		return json;
	}
	
	/**
	 * Deserializes an object from a JSON expression.
	 * TODO: Allow deserialization from a Reader object
	 * @param expression A valid JSON object.
	 * @return The deserialized object.
	 * @throws JSONException
	 */
	public synchronized TableOfAccounts readJSON(String expression) throws JSONException {
		org.json.JSONObject json = new org.json.JSONObject(expression);
		
		//Load primary key gen
		nextAccountKey = json.getLong("nextAccountKey");
		
		//Load users
		JSONArray array = json.getJSONArray("users");
		for (int i = 0; i < array.length(); ++i) {
			UserAccount account = new UserAccount(0);
			account.readJSON(array.getJSONObject(i));
			accountsByEmail.put(account.getEmail(), account);
			accountsByUID.put(account.getUID(), account);
			account.addObserver(this);
		}
		
		return this;
	}
}
