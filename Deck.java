/**
 * A simple deck object with an array of cards and method to print, shuffle and deal from the deck
 * 
 * @author Erik
 */
import java.util.ArrayList;
 
public class Deck extends LQueue<Card>
{
	private int deckSize;

	/**
	 * Constructs a deck of cards, in order by suit then number
	 */
	public Deck()
	{
		super();
		Card[] deck = new Card[52];
      		for(int i = 0; i < 52; i++)
		{
			String suit = null;
			int val = i / 13; 	//val is the suit
			int rank = i % 13 + 1;	//Rank is face value
			if (val == 0) suit = "Clubs";
			else if (val == 1) suit = "Diamonds";
			else if (val == 2) suit = "Hearts";
			else if (val == 3) suit = "Spades";
        		deck[i] = new Card(suit, rank);
			enqueue(new Card(suit, rank));
		}
	}

	/**
	 * Shuffles the deck
	 */
	public void shuffle()
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		while (!isEmpty())
			cards.add(dequeue());
		while(cards.size() > 0)
			enqueue(cards.remove((int)(Math.random() * cards.size())));
	}
	
	/**
	 * Picks the first card from the deck, removes if from the deck, increases top, and returns the card
	 * 
	 * @return The card dealt
	 */
	public Card deal()
	{
	    return dequeue();
	}
}
