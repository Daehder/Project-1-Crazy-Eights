import java.util.ArrayList;

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