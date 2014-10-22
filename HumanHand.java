import java.util.ArrayList;
import java.util.Scanner;

/**
 * A hand that handle human players
 * 
 * @author Erik
 */
public class HumanHand extends Hand {
	private ArrayList<Card> hand;
	
	/**
	 * 
	 */
	public HumanHand() {
		super();
	}

	/**
	 * @param num
	 */
	public HumanHand(int num) {
		super(num);
	}

	/**
	 * @param name
	 */
	public HumanHand(String name) {
		super(name);
	}

	public void takeTurn(Card lastCard, Deck deck) {
		Scanner in = new Scanner(System.in);
		
		printHand(lastCard);
		
		char res = 'x';
		while (res == 'x')
		{
			res = in.next().charAt(0);
			if (res == 's' || res == 'S')
				sort(0);
			else if (res == 'r' || res == 'R') 
				sort(1);
			else if ((res == 'p' || res == 'P'))
			{
				int cardChoice = -1;
				while (cardChoice == -1)
				{
					System.out.println("Choose a card from 1 - " + hand.size() + ": ");
					if (in.hasNextInt())
					{
						cardChoice = in.nextInt();
						if (cardChoice >= 1 && cardChoice <= hand.size())
						{
							if (isPlayable(hand.get(cardChoice - 1), lastCard)) lastCard = hand.remove(cardChoice - 1);
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
						in.next();
					}
				}
				if (lastCard.getValue() == 7)
				{
					lastCard = crazyEight(in);
				}
			}
			else if ((res == 'd' || res == 'D'))
			{
				hand.add(deck.Deal());
			}
			else if (res == 'q' || res == 'Q') return;
			else
			{
				System.out.println("Not a valid response.");
				res = 'x';
			}
		}
	}
	
	protected Card crazyEight(Scanner in) {
		System.out.println("Would you like to change the suit to:\n" +
						   "(C)lubs\n" +
						   "(D)iamonds\n" +
						   "(H)earts\n" +
						   "(S)pades\n");
		char res = 'x';
		Card eight = null;
		while (res == 'x')
		{
			res = in.next().charAt(0);
			if (res == 'c' || res == 'C') 
				eight = new Card(7);			// Creates an 8 of Clubs
			else if (res == 'd' || res == 'D') 
				eight = new Card(20);			// Creates an 8 of Diamonds
			else if (res == 'h' || res == 'H')
				eight = new Card(33);			// Creates an 8 of Hearts
			else if (res == 's' || res == 'S') 
				eight = new Card(46);			// Creates an 8 of Spades
			else
			{
				System.out.println("Not a valid suit");
				res = 'x';
			}
		}
		return eight;
	}
	
	public void printHand(Card lastCard) {
		System.out.println("\nHere is your hand:");
		super.printHand();
		System.out.println("The top card is " + lastCard);
		printInGameMenu();
	}

	
	private void printInGameMenu()
	{
		System.out.println("\nSort by (R)ank\n" +
							"Sort by (S)uit\n" + 
							"(P)lay a card\n" + 
							"(D)raw a card\n" + 
							"(Q)uit to menu\n");
	}
}
