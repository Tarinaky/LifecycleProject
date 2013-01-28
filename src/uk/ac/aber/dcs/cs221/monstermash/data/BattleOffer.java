package uk.ac.aber.dcs.cs221.monstermash.data;

/**
 * Dispatch this Offer to a user if you want to challenge one
 * of their monsters to a fight.
 * @author tarinaky
 *
 */
public class BattleOffer extends Offer {

	private volatile Monster defender = null;
	private volatile Monster challenger = null;
	
	private volatile Battle battle = null;
	
	@Override
	public synchronized void accept() {
		//Assert that the monster's owner has not changed.
		if (defender.getOwner() != this.getReceiver() ) {
			this.getReceiver().removeOffer(this);
			return;//Peace out.
			
		}
		if (challenger.getOwner() != this.getSource() ) {
			this.getReceiver().removeOffer(this);
			return;
		}
		
		//TODO: Handle battle
		
		this.getReceiver().removeOffer(this);
		

	}
	
	/**
	 * Get the Object that represents the results of this battle.
	 * Call this method after accept()ing a battle but before
	 * letting the Offer object out of scope.
	 * 
	 * Returns null if the battle has not been faught: ie invalid challenger/defender etc...
	 * 
	 * NOTE: accept()ing a Battle will remove it from the User's list of offers so
	 * copy a reference into a local variable before accept()ing.
	 */
	public Battle getBattle() {
		if (this.battle.isValid() ) {
			return this.battle;
		} else {
			return null;//The battle likely did not occur, please test for null.
		}
	}
	
	public Monster getDefender() {
		return defender;
	}
	public Monster getChallenger() {
		return challenger;
	}
	public synchronized Offer setChallenger(Monster challenger) {
		this.challenger = challenger;
		return this;
	}
	public synchronized Offer setDefender(Monster defender) {
		this.defender = defender;
		return this;
	}
	

}
