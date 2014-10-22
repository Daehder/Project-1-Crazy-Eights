import java.util.ArrayList;

public class Deck extends LQueue<Card>
{
   private final int DECK_SIZE = 52;
   
   public Deck(int n){}
   
   public Deck()
   {
      for (int i = 0; i < DECK_SIZE; i++)
         enqueue(new Card(i));
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
      ArrayList<Card> cards = new ArrayList<Card>();
      while (!isEmpty())
         cards.add(dequeue());
      while (cards.size() > 0)
         enqueue(cards.remove((int)(Math.random() * cards.size())));
   }
   
   public Card Deal() {
	   return dequeue();
   }
}