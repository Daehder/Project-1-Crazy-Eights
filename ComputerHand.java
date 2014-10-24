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
		hand = super.hand;
	}

	public ComputerHand(String name) {
		super(name);
	}
	
	//Function searches though hand for cards that are playable
	public void findPlayableCards(ArrayList<Card> hand, Card lastCard){
		playableCards = new ArrayList<Card>();
		System.out.println(hand);
		for(Card card: hand){
			if(card.getSuitValue() == lastCard.getSuitValue() || card.getValue() == lastCard.getValue()){
				System.out.println(card);
				playableCards.add(card);
			}
		}
	}

	@Override
	public Card takeTurn(Card lastCard, Deck deck) {
		System.out.println("Last Card Played: " + lastCard);
		findPlayableCards(hand, lastCard);
		
		//Add a parameter for max draw.
		while(playableCards.isEmpty()){
			hand.add(deck.Deal());
			findPlayableCards(hand, lastCard);
		}
		
		int play;
		play = 1; //Change to random function
		switch (play){
		
		// Play highest amount
		case 1:
			int highComboCount = 0;
			combination = new ArrayList<Card>();
			highestCombination = new ArrayList<Card>();
			for(Card testCard: playableCards){
				int comboCount = 0;
				combination.add(testCard);
				for(Card card: hand){
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
				else{
					for(int i = 0; i < combination.size(); i++){
						combination.remove(i);
					}
				}
			}
			if(highestCombination.size() > 1){
				findPlayableCards(highestCombination, lastCard);
				System.out.print("Cards to play:");
				for(Card card: highestCombination){
					hand.remove(card);
					System.out.print(card + ", ");
				}
				System.out.print("\n");
				return playableCards.get(0);
			}
			
		//Play first
		case 2: 
			System.out.println("Card to Play:" + playableCards.get(0));
			hand.remove(playableCards.get(0));
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
