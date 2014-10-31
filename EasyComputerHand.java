/**
 * A simple AI that plays the first card that it can
 *
 * @author Nate
 */
public class EasyComputerHand extends Hand {
	
	/**
	 * Creates an EasyComputerHand with no name
	 */
	public EasyComputerHand() {
		super();
	}
	
	/**
	 * Creates an EasyComputerHand with the name player 'num'
	 *
	 * @param num The number of the player
	 */
	public EasyComputerHand(int num) {
		super(num);
	}
	
	/**
	 * Creates an EasyComputerhand with the name 'name'
	 *
	 * @param name The name of the computer
	 */
	public EasyComputerHand(String name) {
		super(name);
	}
	
	/**
	 * When the computer takes a turn, it plays the first card it can
	 * 
	 * @param lastCard The last card played
	 * @param The deck of cards (for drawing cards)
	 * @return The card played 
	 */
	@Override
	public Card takeTurn(Card lastCard, Deck deck) {
		{
			System.out.println(name() + " has " + size() + " cards in their hand.");
			if (hasPlay(lastCard))
			{
				int loc = firstPlayableLocation(lastCard);
				Card c = hand.remove(loc);
				System.out.println(name() + " played the " + c);
				System.out.println(name() + " has " + size() + " cards in their hand.");
				return c;
			}
			else
			{
				System.out.println(name() + " drew a card.");
				add(deck.Deal());
				System.out.println(name() + " has " + size() + " cards in their hand.");
				return lastCard;
			}
		}
	}
	
	public int firstPlayableLocation(Card c)
	{
		for (int i = 0; i < size(); i++)
		{
			if (isPlayable(hand.get(i), c))
			{
				return i;
			}
		}
		return -1;
	}
	
}
