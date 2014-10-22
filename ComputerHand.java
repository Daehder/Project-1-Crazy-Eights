import java.util.Scanner;

/**
 * A class to handle computer turns
 * 
 * @author Erik
 */
public class ComputerHand extends Hand {

	public ComputerHand() {
		super();
	}

	public ComputerHand(int num) {
		super(num);
	}

	public ComputerHand(String name) {
		super(name);
	}

	@Override
	public Card takeTurn(Card lastCard, Deck deck) {
		
		return lastCard;
	}

	protected Card crazyEight(Scanner in) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
