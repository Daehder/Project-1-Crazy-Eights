import java.util.*;

/**
 * A class to build a CrazyEightsGame. Includes the methods to run and debug the game
 * 
 * @author Erik
 */
public class CrazyEightsGame {
	private static final int HAND_SIZE = 8;
	private Deck deck;	/** The deck that all the cards in the game come from */
	private Hand p1;	/** Player 1's hand. The human player */
	private Hand p2;	/** Player 2's hand. The computer player */
	private Card lastCard;	/** The last card played */
	
	public CrazyEightsGame() {
		Scanner in = new Scanner(System.in);
		char status;
		printGreeting();
		do {
			printMenu();
			status = in.next().charAt(0);
			if(status == 'q' || status == 'Q')
				continue;
			else if(status == 'p' || status == 'P')
				play();
			else if(status == 'r' || status == 'R')
				rules();
			else if(status == 'o' || status == 'O')
				options();
			else
				System.out.println("Please enter a valid selection");
		} while(status != 'q' || status != 'Q');
	}

	private void play() {
		// Creates and Shuffles the deck
		deck = new Deck();
		// TODO Remove next line once deck is confirmed to build correctly
		deck.print();
		deck.shuffle();
		deck.print();
		lastCard = deck.deal();	// Deal the first card to match
		
		// Creates and fills the hands
		p1 = new Hand(1);
		p2 = new Hand(2);
		fillHands(p1, p2);
		
		while(!gameOver()) {
			System.out.println("Here is your hand:\n");
			p1.printHand();
			
		}
		System.out.println("\nWould you like to play again?");
	}
	
	/**
	 * Checks to see if the deck ran out of cards or if one of the players won
	 * 
	 * @return Whether the game is over
	 */
	private boolean gameOver() {
		if(deck.empty())
			System.out.println("The deck ran out of cards. It's a tie.\n");
		else if(p1.size() == 0)
			System.out.println("You got rid of all your cards! You Won!\n");
		else if(p2.size() == 0)
			System.out.println("The computer got rid of all it's cards. Better luck next time.\n");
		return deck.empty() || p1.size() == 0 || p2.size() == 0;
	}

	/**
	 * Fills both hands with HAND_SIZE number of cards
	 * 
	 * @param p1 Player 1's hand
	 * @param p2 Player 2's hand
	 */
	private void fillHands(Hand p1, Hand p2) {
		for(int i = 0; i < HAND_SIZE; i++){
			p1.add(deck.deal());
			p2.add(deck.deal());
		}
				
	}

	/**
	 * Prints the rules
	 */
	private void rules() {
		// TODO Print the rules
		System.out.println("Here are the rules:");
	}
	
	/**
	 * Presents the options and allows them to be changed
	 */
	private void options() {
		// TODO Print the options
		// Ideas: Change the cheat key, implement more cheats, special rules, player names, 
		//			(if we get graphics) themes
	}

	private void printGreeting() {
		System.out.println("Nice greeting here");
	}

	private void printMenu() {
		System.out.println("\n(P)lay\n" +
							"(R)ules\n" + 
							"(O)ptions\n");
	}	
}