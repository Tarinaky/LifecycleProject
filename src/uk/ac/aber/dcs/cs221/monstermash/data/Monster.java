package uk.ac.aber.dcs.cs221.monstermash.data;

import java.util.Date;

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
	
	private volatile int injuries;
	
	public Monster() {
		synchronized (getClass() ) {
			primaryKey = nextPrimaryKey++;	
		}
		
		dateOfBirth = new Date();
		
		injuries = 0;
	}
	
	public long getUID() { return primaryKey; }
	
	public synchronized Monster setOwner(UserAccount owner) { this.owner = owner; return this; }
	public UserAccount getOwner() { return owner; }
	
	public synchronized Monster setName(String name) { this.name = name; return this; }
	public String getName() { return name; }
	
	public synchronized Monster setGender(Gender gender) { this.gender = gender; return this; }
	public boolean isMale() { return (gender == Gender.MALE); }
	
	public long getAge() { return dateOfBirth.getTime(); }
	public double getHealth() {
		return 2 - Math.exp(ageRate * getAge() ); //$2-e^{\lambda t}$
	}
	
	public int getStrength() {
		return (int) (strengthCoefficient*(Math.exp(ageRate * getAge() ) - 1 ) * getHealth());
	}
	
	public int getEvade() {
		return (int) (evadeCoefficient*(Math.exp(ageRate * getAge() ) - 1) * getHealth() );
	}
	
	public int getToughness() {
		return (int) (toughnessCoefficient*(Math.exp(ageRate * getAge() ) - 1) * getHealth() );
	}
	
	
	

}
