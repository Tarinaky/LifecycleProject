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

class JSONObject{}

/**
 * @composed 1 - * Monster
 * @assoc * - * UserAccount
 * @composed 1 - * Offer
*/
class UserAccount extends java.util.Observable {
	private long primaryKey;
	private string email;
	
	private int cash;
	
	private string password;
	private java.util.TreeSet<Monster> monsters;
	private java.util.List<UserAccount> friends;
	private java.util.List<Offer> offers;
	
	public long getUID();	
		
	public UserAccount(long primaryKey){}
	
	public boolean checkPassword(string password){}
	public UserAccount setPassword(String password){}
	
	public UserAccount setEmail(String email){}
	public String getEmail(){}
	
	public JSONObject buildJSON(){}
	public UserAccount readJSON(){}
	
	public void addMonster(Monster monster);
	public void removeMonster(Monster monster);
	
	public UserAccount addFriend(UserAccount newFriend);
	public UserAccount sendOffer(Offer o);
	
	public Offer[] getOffers();
	public UserAccount[] getFriends();
	public Monster[] getMonsters();
	
	public boolean deductCash(int cost);
	public int getCash();
	public int worth();
}
/**
 * @composed 1 - * UserAccount
*/
class TableOfAccounts implements java.util.Observer {
	private long nextAccountKey;
	private HashMap accountsByEmail;
	private HashMap accountsByUID;
	

	public TableOfAccounts(){}
		
	public UserAccount lookup(string email){}
	public UserAccount lookup(long uid);
	public UserAccount addUser(string email){}
	
	public JSONObject buildJSON(){}
	public TableOfAccounts readJSON(JSONObject json){}
}

/**
  
 */
class Monster {
	public static final int MAX_NUM_CHILDREN;
	private static long nextPrimaryKey;
	private static boolean isInit;
	private long primaryKey;
	private UserAccount owner;
	
	private string name;
	public enum Gender {MALE, FEMALE };
	private Gender gender;
	
	private java.util.Date dateOfBirth;

	protected double age_rate;
	
	protected int strengthCoefficient;
	protected int evadeCoefficient;
	protected int toughnessCoefficient;

	protected int fertility;

	protected double injuryChance;
	protected int injuries;

	private boolean forSale;
	private boolean forTupping;
	
	public boolean isForSale();
	public boolean isForSale(boolean b);
	public boolean isForTupping();
	public boolean isForTupping(boolean b);

	public static void init(long nextPrimaryKey);
	
	public Monster();
	protected Monster(long primaryKey);
	
	public long getUID();
	
	public Monster setOwner(UserAccount owner);
	public UserAccount getOwner();
	
	public Monster setName(String name);
	public String getName();
	
	public Monster setGender(Gender gender);
	public boolean isMale();
	
	public long getAge();
	
	public double getHealth();
	public int getStrength();
	public int getEvade();
	public int getToughness();

	protected static double mutation(java.util.Random rand);
	protected static double crossover(java.util.Random rand, double a, double b);
	public static Monster genderateRandom();
	
	public java.util.ArrayList<Monster> breed(Monster father);
	
	public double getFertility();
	public double getInjuryChance();
	public void injure();
	public void reap();
	public int getMaxHP();
	
	public int compareTo(Monster arg0);
	
	public JSONObject buildJSON();
	public static Monster readJSON(UserAccount owner, JSONObject json);
	
	public int worth();

}
	
class FriendOffer extends Offer {}

abstract class Offer {
	private UserAccount source;
	private UserAccount receiver;
	
	public Offer setSource(UserAccount source);
	public Offer setReceiver(UserAccount receiver);
	public UserAccount getSource();
	public UserAccount getReceiver();
	
	public abstract void accept();
	
	public JSONObject buildJSON();
	public static Offer readJSON(UserAccount receiver, TableOfAccounts accounts, JSONObject json);
}

class BattleOffer extends Offer {
	private Monster challenger;
	private Monster challenged;
	
	public BattleOffer setChallenger(Monster challenger);
	public Monster getChallenger();
	public BattleOffer setChallenged(Monster challenged);
	public Monster getChallenged();
}

class RemoteMonster extends Monster {
	protected RemoteServer remote;
}

class RemoteUser extends UserAccount {
	protected RemoteServer remote;
}
/**
 * 
 * @assoc 1 - * RemoteUser
 * @assoc 1 - * RemoteMonster
 */
class RemoteServer {
	private String serverAddress;
	private int port;
	private String serverName;
	private String password;
	
	public RemoteServer setServerAddress(String addr, int port);
	public RemoteServer setServerName(String name);
	public RemoteServer setServerPassword(String password);
	
	public JSONObject query(String query);
	public String getName();
	public boolean authenticate(String password);
	
	public JSONObject buildJSON();
	public static RemoteServer readJSON(JSONObject json);
}
/**
 * 
 * @composed 1 - * RemoteServer
 *
 */
class Servers {
	private HashMap servers;
	public RemoteServer lookup(String name);
	
	public JSONObject buildJSON();
	public static Servers readJSON(JSONObject json);
	
}

	

