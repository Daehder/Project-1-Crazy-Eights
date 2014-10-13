import java.util.*;

/**
 * A class to build a CrazyEightsGame. Includes the methods to run and debug the game
 * 
 * @author Erik
 */
public class CrazyEightsGame {
	private static final int HAND_SIZE = 8;
	private Deck deck;
	private Hand p1;
	private Hand p2;
	
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
		} while(status != 'q' || status == 'Q');
	}

	private void play() {
		// Creates and Shuffles the deck
		deck = new Deck();
		// TODO Remove next line once deck is confirmed to build correctly
		deck.print();
		deck.shuffle();
		deck.print();
		
		// Creates and fills the hands
		p1 = new Hand();
		p2 = new Hand();
		fillHands(p1, p2);
		
		boolean done = false;
		while(!done) {
			System.out.println("Playing game");
			done = true;
		}
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
		// Ideas: Change the cheat key, implement more cheats, special rules,
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
