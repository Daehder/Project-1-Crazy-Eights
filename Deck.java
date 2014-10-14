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
		for(int i = 0; i < 52; i++)
		{
			String suit = null;
			int val = i / 13;
			int rank = i % 13;
			if (val == 0) suit = "Clubs";
			else if (val == 1) suit = "Diamonds";
			else if (val == 2) suit = "Hearts";
			else if (val == 3) suit = "Spades";
			deck[i] = new Card(suit, rank);
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
	 * @return The card dealt
	 */
	public Card deal()
	{
	    Card r = deck[top];
	    deck[top] = null;
	    top++;
	    return r;
	}

	/**
	 * Returns if the deck still has cards in it
	 * 
	 * @return If there are still cards in the deck
	 */
	public boolean empty() {
		return top == deck.length;
	}
}
