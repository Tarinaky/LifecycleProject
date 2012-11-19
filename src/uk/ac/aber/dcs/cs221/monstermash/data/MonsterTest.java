package uk.ac.aber.dcs.cs221.monstermash.data;


import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class MonsterTest extends TestCase {
	
	Monster monster;

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		
		Monster.init(1);
		
		monster = new Monster();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testSetOwner() {
		UserAccount owner = new UserAccount(1);
		monster.setOwner(owner);
		assertTrue(monster.getOwner() == owner);
	}

	@Test
	public void testSetName() {
		String name = "Brian";
		monster.setName(name);
		assertTrue(monster.getName() == name);
	}

	@Test
	public void testSetGender() {
		monster.setGender(Monster.Gender.MALE);
		assertTrue(monster.isMale() );
		monster.setGender(Monster.Gender.FEMALE);
		assertFalse(monster.isMale() );
	}

	@Test
	public void testMutation() {
		java.util.Random rand = new java.util.Random();
		for (int i=0; i < 100; ++i) {
			double mutation = Monster.mutation(rand);
			assertTrue(0 < mutation && mutation < 1);
			System.out.print(mutation+" ");
			
		}
		System.out.println();
	}

	@Test
	public void testGenerateRandom() throws JSONException {
		Monster monster = Monster.generateRandom().setOwner(new UserAccount(1));
		System.out.println("Starter Monster: "+monster.buildJSON().toString() );
		
		assertTrue(monster.getHealth() > 0);
	}

	@Test
	public void testBreed() throws JSONException {
		Monster mother = Monster.generateRandom().setOwner(new UserAccount(1) );
		Monster father = Monster.generateRandom().setOwner(new UserAccount(2) );
		
		ArrayList<Monster> children = mother.breed(father);
		assertTrue(children != null);
		
		JSONArray json = new JSONArray();
		for (Monster child: children) {
			json.put(child.buildJSON() );
		}
		
		System.out.println("Offspring: "+json.toString() );
	}

}
