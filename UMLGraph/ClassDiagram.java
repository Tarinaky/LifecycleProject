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
class UserAccount {
	private long primaryKey;
	private string accountName;
	
	private string password;
	private ArrayList<Monster> listOfMonsters;
		
	public boolean checkPassword(string password){}
}
/**
 * @composed 1 - * UserAccount
*/
class TableOfUserAccounts {
	private HashMap accounts;

	public UserAccount lookup(string accountName){}
}

class Monster {
	private long primaryKey;
	private UserAccount owner;
	
	private string monsterName;
	private boolean gender;
	private int health;
	private java.util.Date dateOfBirth;

	private int strength;
}
	
	
	

