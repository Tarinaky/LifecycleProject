package uk.ac.aber.dcs.cs221.monstermash.data;

/**
 * Dispatch this Offer to a user if you want to challenge one
 * of their monsters to a fight.
 * @author Jacob Smith, jas32
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
		
		this.battle = new Battle(defender, challenger);
		this.getReceiver().removeOffer(this);
	}
	
	/**
	 * Get the Object that represents the results of this battle.
	 * Call this method after accepting a battle but before
	 * letting the Offer object out of scope.
	 * 
	 * Returns null if the battle has not been fought: i.e invalid challenger/defender etc...
	 * 
	 * NOTE: accepting a Battle will remove it from the User's list of offers so
	 * copy a reference into a local variable before accepting.
	 */
	public Battle getBattle() {
		if (this.battle == null) {
			return null;
		}
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
	
	public synchronized BattleOffer setChallenger(Monster challenger) {
		this.challenger = challenger;
		return this;
	}
	
	public synchronized BattleOffer setDefender(Monster defender) {
		this.defender = defender;
		return this;
	}
	
}
