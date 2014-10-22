import java.util.ArrayList;

/**
 * A hand that gets commands from the player
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
}
