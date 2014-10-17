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
   private Node end;
   
   public LQueue(){}
   
   public void enqueue(T element)
   {
      Node temp = new Node(element);
      if (isEmpty())
      {
         front = temp;
         end = front;
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
   
   //sets this LQueue to another LQueue
   public void set(LQueue<T> q)
   {
      front = null;
      end = null;
      while (!(q.isEmpty()))
      {
         enqueue(q.dequeue());
      }
   }
}
