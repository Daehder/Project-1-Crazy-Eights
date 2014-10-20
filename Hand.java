import java.util.ArrayList;

/**
 * A simple class to manage each player's hand
 * 
 * @author Erik
 */
public class Hand {
	private ArrayList<Card> hand;
	private String name;
	
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	/**
	 * Creates a numbered player
	 * 
	 * @param num The number of the player
	 */
	public Hand(int num) {
		super();
		name = "Player " + num;
	}
	
	/**
	 * Creates a player with a custom name
	 * 
	 * @param name The name of the player
	 */
	public Hand(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * Add the Card c to the hand
	 * 
	 * @param c The card to be added to the hand
	 */
	public void add(Card c) {
		hand.add(c);
	}
	
	/**
	 * Removes the card at index i from the hand
	 * 
	 * @param i	The index of the card to remove at (plus 1)
	 * @return	The card that was removed
	 */
	public Card remove(int i) {
		return hand.remove(i-1);
	}
	
	/**
	 * Returns how many card are in the hand
	 * 
	 * @return The number of cards in the hand
	 */
	public int size() {
		return hand.size();
	}
	
	/**
	 * Returns the player's name
	 * 
	 * @return The player's name
	 */
	public String name() {
		return name;
	}
	
	/**
	 * A method to sort the hand by number and Suit
	 * Currently unsupported, throws and unsupported operation exception
	 */
	public void sort() {
		// TODO To be implemented later
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Prints the hand
	 */
	public void printHand() {
		for(int i = 0; i < hand.size(); i++)
			System.out.println(i+1 + ". " + hand.get(i));
	}
}
