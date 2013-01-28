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
	
	@Override
	public void accept() {
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
