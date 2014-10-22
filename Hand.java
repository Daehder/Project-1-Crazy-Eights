import java.util.ArrayList;

public class Hand
{
	private ArrayList<Card> hand;
	private String name;
	
	public Hand()
	{
		hand = new ArrayList<Card>();
		name = "";
	}
	
	public Hand(int num)
	{
		this();
		name = "Player " + num;
	}
	
	public Hand(String name)
	{
		this();
		this.name = name;
	}
	
	public void add(Card c)
	{
		if (c == null)
			System.out.println("Out of cards");
		else 
			hand.add(c);
	}
	
	public Card remove(int i)
	{
		return hand.remove(i);
	}
	
	public Card get(int i)
	{
		return hand.get(i);
	}
	
	public int size()
	{
		return hand.size();
	}
	
	public String name()
	{
		return name;
	}
	
	public void sort(int n)
	{
		if (hand.size() > 0)
		{
			ArrayList<Card> temp = new ArrayList<Card>();
			while (hand.size() > 0)
			{
				int loc = findSmallest(n);
				temp.add(hand.get(loc));
				hand.remove(loc);
			}
			hand = temp;
		}
	}
	
	private int findSmallest(int n)
	{
		int small;
		if (n == 0) 
			small = 53;
		else 
			small = 13;
		int loc = -1;
		for (int i = 0; i < hand.size(); i++)
		{
			if (n == 0)
			{
				if (hand.get(i).getRank() < small)
				{
					small = hand.get(i).getRank();
					loc = i;
				}
			}
			else
			{
				if (hand.get(i).getValue() < small)
				{
					small = hand.get(i).getValue();
					loc = i;
				}
			}
		}
		return loc;
	}
	
	public void printHand()
	{
		System.out.println();
		for(int i = 0; i < hand.size(); i++)
			System.out.println((i + 1) + ". " + hand.get(i));
	}
	
	public boolean hasPlay(Card c)
	{
		for (Card inHand: hand)
			if (isPlayable(inHand, c)) 
				return true;
		return false;
	}
	
	public boolean isPlayable(Card a, Card b)
	{
		return (a.getSuitValue() == b.getSuitValue()) ||
			(a.getValue() == b.getValue()) ||
			(a.getValue() == 7);
	}
}
