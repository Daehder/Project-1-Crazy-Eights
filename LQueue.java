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
  
   public boolean isEmpty()
   {
      return (front == null);
   }
   
   public Node getFront()
   {
      return front;
   }
   
   public Node getEnd()
   {
      return end;
   }
}
