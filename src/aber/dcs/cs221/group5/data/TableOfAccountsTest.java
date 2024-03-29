package aber.dcs.cs221.group5.data;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TableOfAccountsTest {
	
	static TableOfAccounts accounts;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Monster.init(1);
		accounts = new TableOfAccounts();
		accounts.addUser("barry@hotmail.com").setPassword("spider");
		accounts.addUser("colin@gmail.com").setPassword("roflcopter");
		accounts.addUser("locked@yahoo.co.uk");
		
		Monster.generateRandom().setOwner(accounts.lookup("colin@gmail.com") );
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckPassword() {
		assertTrue(accounts.lookup("barry@hotmail.com").checkPassword("spider"));
		
	}
	@Test
	public void testLockedAccount() {
		assertFalse(accounts.lookup("locked@yahoo.co.uk").checkPassword(""));
	}
	@Test
	public void testChangeEmail() {
		accounts.addUser("testChangeEmail@test.com").setEmail("testChangedEmail2@test.com");
		assertTrue(accounts.lookup("testChangedEmail2@test.com") != null);
	}
	
	@Test
	public void testBuildJSON() throws JSONException {
		String data = accounts.buildJSON().toString(4);
		System.out.println(data);
	}
	
	@Test
	public void testReadJSON() throws JSONException {
		String data = "{" +
				"\"nextAccountKey\": 10, " +
				"\"users\": [" +
				"	{ " +
				"	\"email\": \"barry@hotmail.com\", " +
				"	\"password\": \"kargoth\", " +
				"   \"cash\": 0," +
				"	\"primaryKey\": 1," +
				"    \"monsters\": [{" +
                " \"dateOfBirth\": 1353345859915, "+
                " \"evade\": 28, "+
                " \"injuries\": 0,"+
                " \"strength\": 26,"+
                " \"ageRate\": 4.946236546651738E-7,"+
                " \"primaryKey\": 1,"+
                " \"name\": \"Artur\","+
                " \"owner\": 2,"+
                " \"gender\": \"male\","+
                " \"fertility\": 0.12582970453416575,"+
                " \"toughness\": 20,"+
                " \"injuryChance\": 10,"+
                " \"forSale\": false,"+
                " \"forTupping\": false"+
            "}]" +
				"	}] " +
				"}";
		TableOfAccounts loaded = new TableOfAccounts().readJSON(data);
		assertTrue(loaded.lookup("barry@hotmail.com").checkPassword("kargoth"));
		loaded.lookup("barry@hotmail.com").worth();
	}
	
	@Test
	public void testDataSingleton() {
		TableOfAccounts t = DataSingleton.get();
		assertTrue(t != null);
		
		DataSingleton.save();
		
		return;
	}
	
	@Test
	public void testFriends() {
		UserAccount a = accounts.lookup("barry@hotmail.com");
		UserAccount b = accounts.lookup("locked@yahoo.co.uk");
		Offer offer = new FriendOffer();
		offer.setSource(a);
		offer.setReceiver(b);
		b.sendOffer(offer);
		b.getOffers()[0].accept();
		assertTrue(a.getFriends().length > 0);
		assertTrue(b.getFriends().length > 0);
		
		//Remove friend relationship
		a.removeFriend(b);
		
		
	}
	
	@Test
	public void testBattle() {
		UserAccount a = accounts.lookup("barry@hotmail.com");
		UserAccount b = accounts.lookup("locked@yahoo.co.uk");
		
		Monster monsterA = Monster.generateRandom();
		Monster monsterB = Monster.generateRandom();
		
		monsterA.setOwner(a).ageCheat(5*1000*60);
		monsterB.setOwner(b).ageCheat(5*1000*60);
		System.out.println(monsterA);
		System.out.println("Health: "+monsterA.getHealth());
		System.out.println("Strength: "+monsterA.getStrength());
		System.out.println("Toughness: "+monsterA.getToughness());
		System.out.println("Evade: "+monsterA.getEvade());
		
		
		Offer battleOffer = new BattleOffer()
			.setChallenger(monsterA)
			.setDefender(monsterB)
			.setSource(a)
			.setReceiver(b);
		b.sendOffer(battleOffer);
		
		b.getOffers()[0].accept();
		Battle battle = ((BattleOffer) battleOffer).getBattle();
		assertTrue(battle.isValid() );
		System.out.println("Sample battle log:");
		for (String line: battle.getLog()) {
			System.out.println(line);
		}
	}

}
