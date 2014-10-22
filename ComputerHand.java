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
	public void takeTurn(Card lastCard, Deck deck) {

	}

	protected Card crazyEight(Scanner in) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
