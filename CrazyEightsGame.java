import java.util.Scanner;

public class CrazyEightsGame
{
   private static final int HAND_MAX_SIZE = 8;
   private Scanner input = new Scanner(System.in);
   private Deck deck;
   private Hand p1, p2;
   private Card lastCard;
   
   public CrazyEightsGame()
   {
      char status = 'x';
      printGreeting();
      
      while (status != 'q' && status != 'Q')
      {
         printMenu();
         status = input.next().charAt(0);
         if (status == 'q' || status == 'Q') continue;
         else if (status == 'p' || status == 'P') play();
         else if (status == 'r' || status == 'R') rules();
         else if (status == 'o' || status == 'O') options();
         else System.out.println("Please enter a valid selection");
      }
      
      System.out.println("Thank you for playing!");
   }
   
   private void play()
   {
      deck = new Deck();
      deck.shuffle();
      lastCard = deck.deal();
      
      p1 = new Hand(1);
      p2 = new Hand(2);
      fillHands();
      
      while (!gameOver())
      {
         System.out.println("\nHere is your hand:");
         p1.printHand();
         System.out.println("\nThere are " + deck.getDeckSize() + " cards left in the deck.\n" +
                            "The top card is " + lastCard);
         boolean hasPlay = p1.hasPlay(lastCard);
         printInGameMenu(hasPlay);
         char res = 'x';
         while (res == 'x')
         {
            res = input.next().charAt(0);
            if (res == 's' || res == 'S') p1.sort(0);
            else if (res == 'r' || res == 'R') p1.sort(1);
            else if (hasPlay && (res == 'p' || res == 'P'))
            {
               int cardChoice = -1;
               while (cardChoice == -1)
               {
                  System.out.println("Choose a card from 1 - " + p1.size() + ": ");
                  if (input.hasNextInt())
                  {
                     cardChoice = input.nextInt();
                     if (cardChoice >= 1 && cardChoice <= p1.size())
                     {
                        if (p1.isPlayable(p1.get(cardChoice - 1), lastCard)) lastCard = p1.remove(cardChoice - 1);
                        else 
                        {
                           System.out.println("Cannot be played");
                           cardChoice = -1;
                        }
                     }
                  }
                  else 
                  {
                     System.out.println("Enter a valid choice");
                     input.next();
                  }
               }
               if (lastCard.getValue() == 7)
               {
                  crazyEight();
               }
            }
            else if (!hasPlay && (res == 'd' || res == 'D'))
            {
               p1.add(deck.deal());
            }
            else if (res == 'q' || res == 'Q') return;
            else 
            {
               System.out.println("Not a valid response.");
               res = 'x';
            }
         }
         artificialIntelligence();
      }
      System.out.println("\nWould you like to play again?");
   }
   
   private boolean gameOver()
   {
      if (deck.isEmpty()) System.out.println("The deck ran out of cards. It's a tie.\n");
      else if(p1.size() == 0) System.out.println("You got rid of all your cards! You Won!\n");
		else if(p2.size() == 0) System.out.println("The computer got rid of all it's cards. Better luck next time.\n");
		return (deck.isEmpty() || p1.size() == 0 || p2.size() == 0);
   }
   
   private void fillHands()
   {
      for (int i = 0; i < HAND_MAX_SIZE; i++)
      {
         p1.add(deck.deal());
         p2.add(deck.deal());
      }
   }
   
   private void rules()
   {
      System.out.println("Here are the rules:");
   }
   
   private void options()
   {
      System.out.println("Here are the options:");
   }
   
   private void printGreeting()
   {
      System.out.println("Nice greeting here");
   }
   
   private void printMenu()
   {
      System.out.println("\n(P)lay\n" + 
                         "(R)ules\n" + 
                         "(O)ptions\n" +
                         "(Q)uit");
   }
   
   private void printInGameMenu(boolean hasPlay)
   {
      String result = "\nSort by (R)ank\n" +
                        "Sort by (S)uit\n";
      if (hasPlay) result += "(P)lay a card\n";
      else result += "(D)raw a card\n";
      result += "(Q)uit to menu\n";
      System.out.println(result);
   }
   
   private void crazyEight()
   {
      System.out.println("Would you like to change the suit to:\n" +
                         "(C)lubs\n" +
                         "(D)iamonds\n" +
                         "(H)earts\n" +
                         "(S)pades\n");
      char res = 'x';
      while (res == 'x')
      {
         res = input.next().charAt(0);
         if (res == 'c' || res == 'C') lastCard = new Card(7);
         else if (res == 'd' || res == 'D') lastCard = new Card(20);
         else if (res == 'h' || res == 'H') lastCard = new Card(33);
         else if (res == 's' || res == 'S') lastCard = new Card(46);
         else
         {
            System.out.println("Not a valid suit");
            res = 'x';
         }
      }
   }
   
   private void artificialIntelligence()
   {
      return;
   }
}