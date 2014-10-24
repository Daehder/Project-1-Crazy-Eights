import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class to handle computer turns
 * 
 * @author Erik
 */
public class ComputerHand extends Hand {
	private ArrayList<Card> hand;
	private ArrayList<Card> playableCards;
	private ArrayList<Card> combination;
	private ArrayList<Card> highestCombination;


	public ComputerHand() {
		super();
	}

	public ComputerHand(int num) {
		super(num);
	}

	public ComputerHand(String name) {
		super(name);
	}
	
	public void findPlayableCards(ArrayList<Card> hand, Card lastCard){
		for(Card card: hand){
			if(card.getSuitValue() == lastCard.getSuitValue() || card.getValue() == lastCard.getValue()){
				playableCards.add(card);
			}
		}
	}

	@Override
	public Card takeTurn(Card lastCard, Deck deck) {
		findPlayableCards(hand, lastCard);
		
		//Add a parameter for max draw.
		while(playableCards.isEmpty()){
			hand.add(deck.Deal());
			findPlayableCards(hand, lastCard);
		}
		
		int play;
		play = 1; //Change to random function
		switch (play){
		
		//Play first
		case 1: 
			return playableCards.get(0);
		// Play highest amount
		case 2:
			int highComboCount = 0;
			for(Card testCard: playableCards){
				int comboCount = 0;
				combination.add(testCard);
				for(Card card: playableCards){
					if(card.getValue() == testCard.getValue() && !card.equals(testCard)){
						combination.add(card);
						comboCount++;
					}
				}
				if(comboCount > highComboCount){
					highComboCount = comboCount;
					for(int i = 0; i < combination.size(); i++){
						highestCombination.add(i, combination.remove(i));
					}
				}
			}
			findPlayableCards(highestCombination, lastCard);
			return playableCards.get(0);
			
		default:
			break;
		}
		
		
		
		return lastCard;
	}

	protected Card crazyEight(Scanner in) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
