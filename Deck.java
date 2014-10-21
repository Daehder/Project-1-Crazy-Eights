import java.util.ArrayList;
<<<<<<< HEAD

public class Deck extends LQueue<Card>
{
   private final int DECK_SIZE = 52;
   private int inDeck;
   
   public Deck(int n)
   {
      inDeck = 0;
   }
   
   public Deck()
   {
      inDeck = 0;
      String suit;
      int val, rank;
      for (int i = 0; i < DECK_SIZE; i++)
      {
         Card c = new Card(i);
         add(c);
      }
   }
   
   public void print()
   {
      Node n = getFront();
      while (n != null)
      {
         System.out.print("\n" + n.element);
         n = n.next;
      }
      System.out.println();
   }
   
   public void shuffle()
   {
      int x = inDeck;
      ArrayList<Card> cards = new ArrayList<Card>();
      while (!isEmpty())
      {
         cards.add(deal());
      }
      Deck temp = new Deck(0);
      for (int i = 0; i < x; i++)
      {
         int randCard = (int)(Math.random() * cards.size());
         temp.add(cards.get(randCard));
         cards.remove(randCard);
      }
      set(temp);
      inDeck = x;
   }
   
   public Card deal()
   {
      Card r = (Card)(dequeue());
      inDeck--;
      return r;
   }
   
   public void add(Card c)
   {
      enqueue(c);
      inDeck++;
   }
   
   public int getDeckSize()
   {
      return inDeck;
   }
}
=======
 
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
>>>>>>> origin/master
