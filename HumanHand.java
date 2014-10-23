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

	public Card takeTurn(Card lastCard, Deck deck) {
		Scanner in = new Scanner(System.in);
		Card play = lastCard;		// Gets passed back to become the new lastCard
									// set to lastCard so that if the user draws or quits, lastCard is passed back
		sort(1);	// Sorts by number then Suit
		sort(0);
		printHand(lastCard);
		printInGameMenu();
		
		char response = 'x';
		while (response == 'x')
		{
			response = in.next().charAt(0);
			if (response == 'p' || response == 'P')
			{
				play = playCards(lastCard, in);
			}
			else if ((response == 'd' || response == 'D'))
			{
				hand.add(deck.Deal());
			}
			else if (response == 'q' || response == 'Q') 
				break;
			else
			{
				System.out.println("Not a valid responseponse.");
				response = 'x';
			}
		}
		return play;
	}
	
	/**
	 * Gets cards to play, removes the from the hands, and returns the last card played
	 * 
	 * @return The last card played
	 */
	private Card playCards(Card lastCard, Scanner in) {
		Card myCard;
		Card test =  null;
		boolean validPlay = true;
		
		do {	// While the is not a valid play
			System.out.println("Please enter the numbers of cards you want to play");
			myCard = lastCard;	// Compare to the top card on the burn pile
			while(in.hasNextInt() && validPlay) {	// While there are still numbers the user has entered
				test = hand.get(in.nextInt());
				if(isPlayable(test, myCard))
					myCard = test;
				else{
					validPlay = false;
					myCard = lastCard;
				}
			}
		}while(!validPlay);
		
		// Discard Cards from the hand
		return myCard;
	}

	protected Card crazyEight(Scanner in) {
		System.out.println("Would you like to change the suit to:\n" +
						   "(C)lubs\n" +
						   "(D)iamonds\n" +
						   "(H)earts\n" +
						   "(S)pades\n");
		char response = 'x';
		Card eight = null;
		while (response == 'x')
		{
			response = in.next().charAt(0);
			if (response == 'c' || response == 'C') 
				eight = new Card(7);			// Returns an 8 of Clubs
			else if (response == 'd' || response == 'D') 
				eight = new Card(20);			// Returns an 8 of Diamonds
			else if (response == 'h' || response == 'H')
				eight = new Card(33);			// Returns an 8 of Hearts
			else if (response == 's' || response == 'S') 
				eight = new Card(46);			// Returns an 8 of Spades
			else
			{
				System.out.println("Not a valid suit");
				response = 'x';
			}
		}
		return eight;
	}
	
	public void printHand(Card lastCard) {
		System.out.println("\nHere is your hand:");
		super.printHand();
		System.out.println("The top card is " + lastCard);
	}

	
	private void printInGameMenu()
	{
		System.out.println("\n(P)lay a card\n" + 
							"(D)raw a card\n" + 
							"(Q)uit to menu\n");
	}
}


/*
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
}*/