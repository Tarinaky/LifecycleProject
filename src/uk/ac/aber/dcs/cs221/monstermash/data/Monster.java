package uk.ac.aber.dcs.cs221.monstermash.data;

import java.util.Date;

import uk.ac.aber.dcs.cs221.monstermash.util.Name;

/**
 * 
 * @author Jacob Smith, jas32
 *
 */
public class Monster {
	private static volatile long nextPrimaryKey = 1;
	
	private volatile long primaryKey;
	private volatile UserAccount owner;
	
	private volatile String name;
	
	public enum Gender { MALE, FEMALE };
	private volatile Gender gender;
	
	private volatile Date dateOfBirth;
	
	protected volatile double ageRate;
	protected volatile int strengthCoefficient;
	protected volatile int evadeCoefficient;
	protected volatile int toughnessCoefficient;
	
	protected volatile int fertility;
	protected volatile double injuryChance;
	
	protected static Name nameGen;
	
	private volatile int injuries;
	
	/**
	 * Public constructor.
	 * 
	 * Assigns the next available primary key and initialises the date of
	 * birth field to this instant.
	 */
	public Monster() {
		synchronized (getClass() ) {
			primaryKey = nextPrimaryKey++;
			if (nameGen == null) { nameGen = new Name(); }
		}
		
		dateOfBirth = new Date();
		
		injuries = 0;
	}
	
	/**
	 * 
	 * @return This monster's primary key.
	 */
	public long getUID() { return primaryKey; }
	
	/**
	 * 
	 * @param owner The monster's owner.
	 * @return This monster object.
	 */
	public synchronized Monster setOwner(UserAccount owner) { this.owner = owner; return this; }
	/**
	 * 
	 * @return The monster's owner.
	 */
	public UserAccount getOwner() { return owner; }
	
	/**
	 * Customise a monster with a name.
	 * @param name The monster's new name.
	 * @return The monster object.
	 */
	public synchronized Monster setName(String name) { this.name = name; return this; }
	/**
	 * 
	 * @return The monster's name.
	 */
	public String getName() { return name; }
	
	/**
	 * @see Gender
	 * @param gender The monster's gender.
	 * @return This monster object.
	 */
	public synchronized Monster setGender(Gender gender) { this.gender = gender; return this; }
	/**
	 * 
 	 * @return True iff this monster is male.
	 */
	public boolean isMale() { return (gender == Gender.MALE); }
	/**
	 * 
	 * @return The monster's age in seconds.
	 */
	public long getAge() { return dateOfBirth.getTime(); }
	/**
	 * 
	 * @return The monster's health, less than 1. If less than 0 this indicates the monster should be reaped.
	 */
	public double getHealth() {
		return 2 - Math.exp(ageRate * getAge() ); //$2-e^{\lambda t}$
	}
	/**
	 * 
	 * @return The monster's strength score.
	 */
	public int getStrength() {
		return (int) (strengthCoefficient*(Math.exp(ageRate * getAge() ) - 1 ) * getHealth());
	}
	/**
	 * 
	 * @return The monster's chance at evading an incoming blow.
	 */
	public int getEvade() {
		return (int) (evadeCoefficient*(Math.exp(ageRate * getAge() ) - 1) * getHealth() );
	}
	/**
	 * 
	 * @return The monster's toughness score.
	 */
	public int getToughness() {
		return (int) (toughnessCoefficient*(Math.exp(ageRate * getAge() ) - 1) * getHealth() );
	}
	
	
	

}
