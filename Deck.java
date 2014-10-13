/**
 * A simple deck object with an array of cards and method to print, shuffle and deal from the deck
 * 
 * @author Erik
 */
public class Deck
{
    // Creates the array for the deck of cards
	private Card[] deck;
	private int top;

	/**
	 * Constructs a deck of cards, in order by suit then number
	 */
	public Deck()
	{
		deck = new Card[52];
		for(int i = 1; i <= 52; i++)
		{
			String Suit = null;
		    if(i >= 1 && i <= 13)
		    {
		    	Suit = "Clubs";
			    Card a = new Card(Suit, i);
			    deck[i - 1] = a;
		    }
		    else if(i >= 14 && i <= 26)
		    {
		    	Suit = "Diamonds";
		        Card a = new Card(Suit, i - 13);
		        deck[i - 1] = a;
		    }
		    else if(i >= 27 && i <= 39)
		    {
		        Suit = "Hearts";
		        Card a = new Card(Suit, i - 26);
		        deck[i - 1] = a;
		    }
		    else
		    {
		    	Suit = "Spades";
                Card a = new Card(Suit, i - 39);
                deck[i - 1] = a;
		    }
		}
	}
	
	/**
	 * Prints out the deck, starting at top
	 */
	public void print()
	{
	    for (int c = top; c < 52; c++)
	    {
	        System.out.println(deck[c]);
	    }
	    System.out.println();     //adds an extra line for readability
	}
	
	/**
	 * Shuffles the deck
	 */
	public void shuffle()
	{
	// uses a for look to go down the deck
	    for(int c = 0; c < 52; c++)
	    {
	// picks a random number
	        int cardToSwitch = (int)(Math.random() * 52);
	// Store the cards at that original and random locations
	        Card s = deck[cardToSwitch];
            Card o = deck[c];
	// Switches the random card with the card at the current location
	        deck[cardToSwitch] = o;
	        deck[c] = s;
	    }
	}
	
	/**
	 * Picks the first card from the deck, removes if from the deck, increases top, and returns the card
	 * 
	 * @return
	 */
	public Card deal()
	{
	    Card r = deck[top];
	    deck[top] = null;
	    top++;
	    return r;
	}
}