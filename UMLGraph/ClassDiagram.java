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
 * @note accountNames should be unique, but can be changed (as primaryKey is used to persist relationships).
 * @note checkPassword returns true iff the argument matches the password stored in the instance.
*/
class UserAccount {
	private long primaryKey;
	private string email;
	
	private string password;
	private ArrayList<Monster> listOfMonsters;
		
	public boolean checkPassword(string password){}
}
/**
 * @composed 1 - * UserAccount
 * @note TableOfUserAccounts is used to resolve user account names to UserAccount instances.
*/
class TableOfUserAccounts {
	private HashMap accounts;

	public UserAccount lookup(string email){}
	public UserAccount addUser(string email){}
}

/**
 * @note owner is a handle back to the monster's current owner.
 * @note Unlike UserAccounts, monsters do not need unique names.
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
	
	
	

