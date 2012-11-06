package uk.ac.aber.dcs.cs221.monstermash.data;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class MonsterTest extends TestCase {
	
	Monster monster;

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		
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
	public void testGenerateRandom() {
		Monster monster = Monster.generateRandom();
		System.out.println(monster);
	}

	@Test
	public void testBreed() {
		Monster mother = Monster.generateRandom();
		Monster father = Monster.generateRandom();
		
		ArrayList<Monster> children = mother.breed(father);
		assertTrue(children != null);
		System.out.println("Breeding output: "+children);
	}

}
