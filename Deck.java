/**
 * A simple deck object with an array of cards and method to print, shuffle and deal from the deck
 * 
 * @author Erik
 */
import java.util.ArrayList;
 
public class Deck extends LQueue
{
    // Creates the array for the deck of cards
	private Card[] deck;
	private int deckSize = 52;

	/**
	 * Constructs a deck of cards, in order by suit then number
	 */
	public Deck()
	{
		deck = new Card[52];
      		for(int i = 0; i < 52; i++)
		{
			String suit = null;
			int val = i / 13; 	//val is the suit
			int rank = i % 13;	//Rank is face value
			if (val == 0) suit = "Clubs";
			else if (val == 1) suit = "Diamonds";
			else if (val == 2) suit = "Hearts";
			else if (val == 3) suit = "Spades";
        		deck[i] = new Card(suit, rank);
			enqueue(new Card(suit, rank));
		}
	}
	
	/**
	 * Prints out the deck, starting at top
	 */
	public void print()
	{
		Deck temp = this;
		while (!(temp.isEmpty()))
		{
        		System.out.println(temp.dequeue());
		}
		System.out.println();     //adds an extra line for readability
	}
	
	/**
	 * Shuffles the deck
	 */
	public void shuffle()
	{
		int x = deckSize;
		ArrayList<Card> cards = new ArrayList<Card>();
		while (!isEmpty())
		{
			cards.add(deal());
		}
		Deck temp = new Deck();
		for (int i = 0; i < x; i++)
		{
			int randCard = (int)(Math.random() * cards.size());
			temp.enqueue(cards.get(randCard));
			cards.remove(randCard);
		}
      		set(temp);
	}
	
	/**
	 * Picks the first card from the deck, removes if from the deck, increases top, and returns the card
	 * 
	 * @return The card dealt
	 */
	public Card deal()
	{
	    Card r = (Card)(dequeue());
	    deckSize--;
	    return r;
	}
}
