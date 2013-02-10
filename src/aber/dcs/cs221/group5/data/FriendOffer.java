package aber.dcs.cs221.group5.data;

/**
 * Handles the acceptance and rejection of friend offers.
 * @author Jacob Smith, jas32
 *
 */
public class FriendOffer extends Offer {

	@Override
	public synchronized void accept() {
		getSource().addFriend(getReceiver() );
		getReceiver().addFriend(getSource() );		
		getReceiver().removeOffer(this);
		
	}
	
}
