package uk.ac.aber.dcs.cs221.monstermash.data;

/**
 * Abstract class that all offer classes inherit.
 * @author Jacob Smith, jas32
 *
 */

public abstract class Offer {
	
	private volatile UserAccount source;
	private volatile UserAccount receiver;
	
	/**
	 * Set the offer's sending user.
	 * @param source The user sending the offer.
	 * @return This.
	 */
	public synchronized Offer setSource(UserAccount source) {
		this.source = source;
		return this;
	}
	
	/**
	 * Set's the offer's receiving user.
	 * This does not, however, send the offer. This must be done with {@link UserAccount#sendOffer(Offer)}.
	 * @param receiver The receiving user who must action this offer.
	 * @return This.
	 */
	public synchronized Offer setReceiver(UserAccount receiver) {
		this.receiver = receiver;
		return this;
	}
	
	public UserAccount getSource() { return source; }
	public UserAccount getReceiver() { return receiver; }
	
	/**
	 * Overload with the logic to 'accept' this type of offer. ie a FriendOffer might set the
	 * users as friends.
	 */
	public abstract void accept();
	
}
