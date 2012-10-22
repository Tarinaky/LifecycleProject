package uk.ac.aber.dcs.cs221.monstermash.data;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class TableOfAccounts implements Observer {
	static int nextAccountKey;
	
	private HashMap<String,UserAccount> accounts;

	public UserAccount lookup(String email){
		return accounts.get(email);
	}
	public UserAccount addUser(String email){
		UserAccount user = new UserAccount();
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
	
	
}
