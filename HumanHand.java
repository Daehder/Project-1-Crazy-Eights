import java.util.ArrayList;
import java.util.Collections;
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
		
		char response = 'x';
		while (response == 'x')
		{
			printHand(lastCard);
			printInGameMenu();
			response = in.next().charAt(0);
			if (response == 's' || response == 'S'){
				sort(0);
				response = 'x';
			}
			else if (response == 'r' || response == 'R'){ 
				sort(1);
				response = 'x';
			}
			else if (response == 'p' || response == 'P')
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
			else if (response == 'e' || response == 'E' ) 
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
	 * Must follow the cards to play with a char
	 * Just entering a char will exit back out to the menu
	 * Users can also only use the cheat once per turn
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
			int nextInt = 0;
			while(in.hasNextInt() && validPlay && nextInt != -2) {	// While there are still numbers the user has entered (and they haven't cheated)
				nextInt = in.nextInt() - 1;	// The location in the hand of the card to play
				if(nextInt == -2) {	// If the user enters the cheat -1, play the first card
					cardPositions.add(0);
				}
				else if(nextInt >= 0 && nextInt < size()){
					test = hand.get(nextInt);	// Get the card at that spot
					if(test.getValue() == 7){	// If the card is an 8
						myCard = crazyEight(in);
						System.out.println("Trying to play the " + test);
						cardPositions.add(nextInt);
					}
					else if(isPlayable(test, myCard)){
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
		
		Collections.sort(cardPositions);	// Puts the card positions in order, then reverses it to prevent errors
		Collections.reverse(cardPositions);	// with the fact that removing cards from arraylists will mess with the indices
		
		for(Integer i: cardPositions)	// Removes all the card to play from the hand
			System.out.println("Playing " + hand.remove((int)i));	// Informs the player and removes the card from the hand
		return myCard;	// Returns the last card played
	}

	private Card crazyEight(Scanner in) {
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
		System.out.println("\nSort by (S)uit\n" +
							"Sort by (R)ank\n" +
							"(P)lay a card\n" + 
							"(D)raw a card\n" + 
							"(E)to end your turn\n");
	}
}