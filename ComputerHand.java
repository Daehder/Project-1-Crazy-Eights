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
	private ArrayList<Card> eights;
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
		eights = new ArrayList<Card>();
		System.out.println(hand);
		for(Card card: hand){
			if(card.getValue() == 8){
				eights.add(card);
			}
			else if(card.getSuitValue() == lastCard.getSuitValue() || card.getValue() == lastCard.getValue()){
				//System.out.println(card);
				playableCards.add(card);
			}
		}
	}

	@Override
	public Card takeTurn(Card lastCard, Deck deck) {
		System.out.println("Last Card Played: " + lastCard);
		findPlayableCards(hand, lastCard);
		
		//Add a parameter for max draw.
		while(playableCards.isEmpty() && eights.isEmpty()){
			hand.add(deck.Deal());
			findPlayableCards(hand, lastCard);
			
		}
		
		int play;
		play = 0; //Change to random function
		switch (play){
		//Play an eight
		case 0:
			//If only an eight can be played, find which suit hand contains the most of and make the 8 that type.
			if(playableCards.isEmpty() && !eights.isEmpty()){
				int suitCount = 0;
				int highestSuitCount = 0;
				int newEightSuitValue = 0;
				for(int i = 0; i < 3; i++){
					for(Card card: hand){
						if(card.getSuitValue() == i && !(card.getValue() == 8)){
							suitCount++;
						}
					}
					if(suitCount > highestSuitCount){
						highestSuitCount = suitCount;
						newEightSuitValue = i;
					}
				}
				hand.remove(eights.get(0));
				Card newEight = new Card((newEightSuitValue * 13) + 7);
				System.out.println("New Eight: " + newEight.toString());
				System.out.println("Card to Play:" + newEight);
				eights.remove(0);
				return newEight;
			}
			
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
		
		
		System.out.println("DID NOT PLAY");
		return lastCard;
	}

	protected Card crazyEight(Scanner in) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
