public class Card
{
   private int rank, value, suit;

 	public Card(int rank)
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
 		String output;
 		if(value == 0) output = "Ace";
 		else if(value == 10) output = "Jack";
 		else if(value == 11) output = "Queen";
 		else if(value == 12) output = "King";
 		else output = "" + (value + 1);
 		return output + " of " + getSuit();
 	}
}