<<<<<<< HEAD
public class Card
{
   private int rank, value, suit;

 	public Card(int rank)
=======
/**
 * A simple card object with a suit, value, and methods to get that info, compare to another card, 
 * and get a human readable string of the card value and suit
 * 
 * @author Erik Miller
 */
 public class Card implements Comparable<Object>
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
>>>>>>> origin/master
 	{
 		this.rank = rank;
      value = rank % 13;
      suit = rank / 13;
   }
   
   public int getRank()
   {
      return rank;
   }

 	public int getValue()
 	{
 		return value;
 	}
   
   public int getSuitValue()
   {
      return suit;
   }

	public String getSuit()
	{
		if (suit == 0) return "Clubs";
      else if (suit == 1) return "Diamonds";
      else if (suit == 2) return "Hearts";
      else return "Spades";
	}

 	public String toString()
 	{
<<<<<<< HEAD
 		String output;
 		if(value == 0) output = "Ace";
 		else if(value == 10) output = "Jack";
 		else if(value == 11) output = "Queen";
 		else if(value == 12) output = "King";
 		else output = "" + (value + 1);
 		return output + " of " + getSuit();
=======
 		String output = null;
 		if(value == 1) output = "Ace";
 		else if(value == 11) output = "Jack";
 		else if(value == 12) output = "Queen";
 		else if(value == 13) output = "King";
 		else output = "" + value;
 		return output + " of " + suit;
>>>>>>> origin/master
 	}
}
