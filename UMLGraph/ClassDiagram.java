/**
 * @opt hide
*/
class string{}
/**
 * @opt hide
*/
class HashMap{}
/**
 * @opt hide
*/
class ArrayList<Monster>{}

/**
 * @composed 1 - * Monster
*/
class UserAccount extends java.util.Observable {
	private long primaryKey;
	private string email;
	
	private string password;
	private ArrayList<Monster> listOfMonsters;
		
	public UserAccount(long primaryKey){}
	
	public boolean checkPassword(string password){}
	public UserAccount setPassword(String password){}
	
	public UserAccount setEmail(String email){}
	public String getEmail(){}
	
	public JSONObject buildJSON(){}
	public UserAccount readJSON(){}
}
/**
 * @composed 1 - * UserAccount
*/
class TableOfAccounts implements java.util.Observer {
	private long nextAccountKey;
	private HashMap accounts;

	public TableOfAccounts(){}
		
	public UserAccount lookup(string email){}
	public UserAccount addUser(string email){}
	
	public JSONObject buildJSON(){}
	public TableOfAccounts readJSON(String expression){}
}

/**
*/
class Monster {
	private long primaryKey;
	private UserAccount owner;
	
	private string monsterName;
	private boolean gender;
	private int health;
	private java.util.Date dateOfBirth;

	private int strength;
}
	
	
	

