package uk.ac.aber.dcs.cs221.monstermash.data;

public class FriendOffer extends Offer {

	@Override
	public synchronized void accept() {
		getSource().addFriend(getReceiver() );
		getReceiver().addFriend(getSource() );
		
		getReceiver().removeOffer(this);
		
	}


	
}
