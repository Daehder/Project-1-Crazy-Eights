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
      
      public String toString()
      {
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
   
   public LQueue()
   {
      size = 0;
   }
   
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
      size++;
   }
   
   public T dequeue() throws DeckEmptyException
   {
      if (isEmpty()) throw new DeckEmptyException();
      else
      {
         size--;
         Node temp = front;
         front = front.next;
         return temp.element;
      }
   }
  
   public boolean isEmpty()
   {
      return (size == 0);
   }
   
   public Node getFront()
   {
      return front;
   }
   
   public int getSize()
   {
      return size;
   }
}
