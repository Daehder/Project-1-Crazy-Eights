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
			else if (status == 'p' || status == 'P') { 
				play();
				System.out.println("\nWould you like to play again?");
			}
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
		lastCard = deck.Deal();
		
		p1 = new HumanHand(1);
		p2 = new ComputerHand(2);
		fillHands();
		
		//GameFrame game = new GameFrame(p1, p2, deck, lastCard);
		
		while (!gameOver())
		{
			lastCard = p1.takeTurn(lastCard, deck);
			lastCard = p2.takeTurn(lastCard, deck);
		}
	}
   
   /* Separate out into EasyComputerHand
    * private Card artificialIntelligence(Deck d, Hand p2, Card lastCard)
	{
      System.out.println(p2.name() + " has " + p2.size() + " cards in their hand.");
		if (p2.hasPlay(lastCard))
      {
         int loc = p2.firstPlayableLocation(lastCard);
         Card c = p2.remove(loc);
         System.out.println(p2.name() + " played the " + c);
         System.out.println(p2.name() + " has " + p2.size() + " cards in their hand.");
         return c;
      }
      else 
      {
         System.out.println(p2.name() + " drew a card.");
         p2.add(d.dequeue());
         System.out.println(p2.name() + " has " + p2.size() + " cards in their hand.");
         return lastCard;
      }
	}*/
	
	private boolean gameOver()
	{
		if (deck.isEmpty())
			System.out.println("The deck ran out of cards. It's a tie.\n");
		else if(p1.size() == 0)
			System.out.println("You got rid of all your cards! You Won!\n");
		else if(p2.size() == 0)
			System.out.println("The computer got rid of all it's cards. Better luck next time.\n");
		return (deck.isEmpty() || p1.size() == 0 || p2.size() == 0);
	}
	
	private void fillHands()
	{
		for (int i = 0; i < HAND_MAX_SIZE; i++)
		{
			p1.add(deck.Deal());
			p2.add(deck.Deal());
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
		System.out.println("Welcome to Crazy Eights! by 'Get Decked' 2014");
		System.out.println("A game where champions are made and losers get played,");
		System.out.println("a game of luck & wit, see if you care for it.");
		System.out.println("Follow the Directions below to get started.");
	}
	
	private void printMenu()
	{
		System.out.println("\n(P)lay\n" +
				     "(R)ules\n" +
				     "(O)ptions\n" +
				     "(Q)uit");
	}

	public Hand getHand(int i) {
		if(i == 1)
			return p1;
		return p2;
	}

	public Deck getDeck() {
		return deck;
	}

	public Card getLastCard() {
		return lastCard;
	}
}
