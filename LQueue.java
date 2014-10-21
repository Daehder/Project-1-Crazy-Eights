import java.lang.RuntimeException;
import java.util.ArrayList;

public class LQueue<T>
{  
   public class Node
   {
	   	public T element;
      	public Node next;
      	public Node(T element)
      	{
      		this.element = element;
      	}
      	
      	/**
      	 * Returns the toString of the Element.
      	 * Used when printing elements
      	 */
      	@Override
		public String toString() {
      		return element.toString();
      	}
      
   }
   
   public static class DeckEmptyException extends RuntimeException
   {
      public DeckEmptyException()
      {
         super();
      }
      public DeckEmptyException(String message)
      {
         super(message);
      }
   }
   
   private Node front;
   private int size;
   
   public LQueue(){
	   front = null;
	   size = 0;
   }
   
   public void enqueue(T element)
   {
      size++;
	  Node temp = new Node(element);
      if (isEmpty())
      {
         front = temp;
      }
      else
      {
         temp.next = front;
         front = temp;
      }
   }
   
   public T dequeue() throws DeckEmptyException
   {
      if (isEmpty()) 
    	  throw new DeckEmptyException();
      size--;
      Node temp = front;
      front = front.next;
      return temp.element;
   }
<<<<<<< HEAD
  
=======
   
   //isEmpty will be used to check if the deck is empty.
>>>>>>> origin/master
   public boolean isEmpty()
   {
      return size <= 0;
   }
   
   /**
    * Prints the whole queue recursively
    */
   public void print() {
	   print(front);
   }
<<<<<<< HEAD

   public void set(LQueue<T> q)
   {
      ArrayList<T> arr = new ArrayList<T>();
=======
   
   /**
    * Prints the next element and ,if there is another element, calls itself again
    * 
    * @param next The element to print
    */
   public void print(Node next) {
	   System.out.println(next);	// Prints the current element
	   if(next.next != null)		// If there is another card, print it
		   print(next.next);
   }
   
   /* Removed, as this simply transfers to this LQueue, does not copy
    * 
    * //sets this LQueue to another LQueue
   public void set(LQueue<T> q)
   {
      front = null;
>>>>>>> origin/master
      while (!(q.isEmpty()))
      {
         arr.add(q.dequeue());
      }
      front = end = null;
      for (T element : arr)
      {
         enqueue(element);
      }
<<<<<<< HEAD
   }
   
   public Node getFront()
   {
      return front;
   }
   
   public Node getEnd()
   {
      return end;
   }
=======
   }*/
>>>>>>> origin/master
}
