/**
 * A simple card object with a suit, value, and methods to get that info, compare to another card, 
 * and get a human readable string of the card value and suit
 * 
 * @author Erik Miller
 */
 public class Card implements Comparable
 {
 	private String suit;
 	private int value;
 	
 	/**
 	 * Constructs a card
 	 * 
 	 * @param suit	The suit of the card
 	 * @param value	The value of the card
 	 */
 	public Card(String suit, int value)
 	{
 		this.suit = suit;
 		this.value = value;
 	}
 	
 	/**
 	 * Returns the number value of the card
 	 * 
 	 * @return	The number value of the card
 	 */
 	public int getValue()
 	{
 		return value;
 	}

 	/**
 	 * Returns the suit of the card
 	 * 
 	 * @return	The suit of the card
 	 */
	public String getSuit()
	{
		return suit;
	}
	
	/**
	 * Compares the value of this card to the card "other"
	 * 
	 * @param other The card to compare to
	 * @return	returns positive if this is higher, negative if this is lower, and 0 if this is equal to other
	 */
	public int compareTo(Object other)
	{
		if(other instanceof Card)
		{
			if(this.value == 1 || ((Card)other).value == 1)
		    if(this.value == 1 && this.value == 1)
		        return 0;
		    else if(this.value == 1)
		        return 1;
		    else
		        return -1;
	    	return this.value - ((Card)other).value;
		}
		return 0;
	}
	
	/**
	 * MODIFIED FOR CRAZY EIGHTS PROJECT: returns if the card has the same value or suit as the card "other"
	 * 
	 * @param other The card to compare to
	 * @return 	Whether the card is equal in value or suit to the other
	 */
	public boolean equals(Card other)
	{
		return((this.value) == (other.value));
	}

	/**
	 * Returns the card in a human readable string
	 * 
	 * @return A string with the value and suit of the card
	 */
 	public String toString()
 	{
 		String output = null;
 		if(value == 0) output = "Ace";
 		else if(value == 10) output = "Jack";
 		else if(value == 11) output = "Queen";
 		else if(value == 12) output = "King";
 		else output = "" + value;
 		return output + " of " + suit;
 	}
 }
