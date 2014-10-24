import java.util.ArrayList;
import java.util.Scanner;

/**
 * A hand that handle human players
 * 
 * @author Erik
 */
public class HumanHand extends Hand {
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
		sort(1);	// Sorts by number
		printHand(lastCard);
		printInGameMenu();
		
		char response = 'x';
		while (response == 'x')
		{
			response = in.next().charAt(0);
			if (response == 'p' || response == 'P')
			{
				play = playCards(lastCard, in);
				if(lastCard.toString().equals(play.toString())) {	// Since Cards are not comparable, compare their strings
						// If the played card is the same as the last card played, nothing has changed, so ask them to pick again
					System.out.println("\nPlease choose another option:");
					printInGameMenu();
					response = 'x';
				}
			}
			else if ((response == 'd' || response == 'D'))
			{
				add(deck.Deal());
				System.out.println("Drew " + hand.get(hand.size() - 1) +
									"\n(P) to play again or" +
									"\n(E) to end your turn");
				response = 'x';
			}
			else if (response == 'q' || response == 'Q' || response == 'e' || response == 'E' ) 
				break;
			else
			{
				System.out.println("Not a valid response.");
				response = 'x';
			}
		}
		System.out.println("Playing " + play + " and ending the turn");
		return play;
	}
	
	/**
	 * Gets cards to play, removes the from the hands, and returns the last card played
	 * Must follow the cards
	 * 
	 * @return The last card played
	 */
	private Card playCards(Card lastCard, Scanner in) {
		Card myCard;
		Card test =  null;
		boolean validPlay = true;
		ArrayList<Integer> cardPositions;
		
		System.out.println("Please enter the numbers of cards you want to play followed by (P), or just a letter to exit to exit");
		do {	// While the is not a valid play
			myCard = lastCard;	// Compare to the top card on the burn pile
			validPlay = true;	// Start a valid attempt
			cardPositions = new ArrayList<Integer>();	// Create an empty cardPositions arraylist
			while(in.hasNextInt() && validPlay) {	// While there are still numbers the user has entered
				int nextInt = in.nextInt() - 1;	// The location in the hand of the card to play
				if(nextInt == -2) {	// If the user enters the cheat -1, play the first card
					// Get first valid card
					// Play it
				}
				else if(nextInt >= 0 && nextInt < size()){
					test = hand.get(nextInt);	// Get the card at that spot
					if(isPlayable(test, myCard)){
						myCard = test;
						System.out.println("Trying to play the " + test);
						cardPositions.add(nextInt);
					}
					else{
						System.out.println("Cannot play " + test + ". Please try another set of cards");
						validPlay = false;
						myCard = lastCard;
					}
				}
				else{	// If the card isn't in the hand, this isn't a valid play
					System.out.println("That is not a card in the hand");
					validPlay = false;
					myCard = lastCard;
				}
			}
			in.nextLine();// Clears the input
		}while(!validPlay);
		
		for(Integer i: cardPositions){
			System.out.println("Playing " + hand.remove((int)i));	// Informs the player and removes the card from the hand
		}
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
							"(E)to end your turn\n");
	}
}