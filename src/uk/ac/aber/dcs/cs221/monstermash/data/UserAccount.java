package uk.ac.aber.dcs.cs221.monstermash.data;

import java.util.ArrayList;

public class UserAccount extends java.util.Observable {
	static long nextAccountKey = 1;
	
	private long primaryKey;
	private String email;
	
	private String password;
	private ArrayList<Object> listOfMonsters;
		
	public boolean checkPassword(String password){
		return (this.password == password);
	}
	
	public UserAccount() {
		primaryKey = nextAccountKey++; // Assign next key and increment.
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
}

