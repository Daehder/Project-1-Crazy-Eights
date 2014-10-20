//LQueue will handle a live deck, allowing cards to be removed 
//without having to handle a null chunk in an array.
//Cards played will be removed, shuffling will restock the deck.

import java.lang.RuntimeException;

public class LQueue<T>
{  
   private class Node
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
   
   public LQueue(){}
   
   public void enqueue(T element)
   {
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
      if (isEmpty()) throw new DeckEmptyException();
      else
      {
         Node temp = front;
         front = front.next;
         return temp.element;
      }
   }
   
   //isEmpty will be used to check if the deck is empty.
   public boolean isEmpty()
   {
      return (front == null);
   }
   
   /**
    * Prints the whole queue recursively
    */
   public void printQueue() {
	   print(front);
   }
   
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
      while (!(q.isEmpty()))
      {
         enqueue(q.dequeue());
      }
   }*/
}
