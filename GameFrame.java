import java.awt.*;
import java.awt.event.*;
import java.awt.Frame;
import javax.swing.*;
import javax.swing.event.*;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ArrayList;

public class GameFrame extends JFrame
{
   private JPanel gameMat, yogaMat, mouseMat, noManMat, cardStack, deckStack;
   private JButton deck, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14;
   private ArrayList<JButton> playerCards;

   public GameFrame(CrazyEightsGame game) {
		this(game.getHand(1), game.getHand(2), game.getDeck(), game.getLastCard());
	}

public GameFrame(Hand playerHand, Hand computerHand, Deck deck, Card lastCard)
   {
   	
   	JPanel panel = new JPanel();
   	getContentPane().add(panel, BorderLayout.CENTER);

      setResizable(false);
      card1= new JButton("");
      card2= new JButton("");
      card3= new JButton("");
      card4= new JButton("");
      card5= new JButton("");
      card6= new JButton("");
      card7= new JButton("");
      card8= new JButton("");
      card9= new JButton("");
      card10= new JButton("");
      card11= new JButton("");
      card12= new JButton("");
      card13= new JButton("");
      card14= new JButton("");

      playerCards= new ArrayList<JButton>();
      playerCards.add(card1);
      playerCards.add(card2);
      playerCards.add(card3);
      playerCards.add(card4);
      playerCards.add(card5);
      playerCards.add(card6);
      playerCards.add(card7);
      playerCards.add(card8);
      playerCards.add(card9);
      playerCards.add(card10);
      playerCards.add(card11);
      playerCards.add(card12);
      playerCards.add(card13);
      playerCards.add(card14);

      yogaMat= new JPanel();
      yogaMat.setPreferredSize(new Dimension(450, 150));
      yogaMat.setBorder(BorderFactory.createEtchedBorder());
      yogaMat.setLayout(new GridLayout(5, 1));

      noManMat= new JPanel();
      noManMat.setPreferredSize(new Dimension(450, 150));
      noManMat.setBorder(BorderFactory.createEtchedBorder());
      noManMat.setLayout(new GridLayout(5, 1));

      mouseMat= new JPanel();
      mouseMat.setPreferredSize(new Dimension(450, 150));
      mouseMat.setBorder(BorderFactory.createEtchedBorder());
      mouseMat.setLayout(new GridLayout(5, 1));

      yogaMat= new JPanel();
      yogaMat.setPreferredSize(new Dimension(450, 150));
      yogaMat.setBorder(BorderFactory.createEtchedBorder());
      yogaMat.setLayout(new GridLayout(5, 1));

      getContentPane().add(yogaMat, BorderLayout.SOUTH);
      getContentPane().add(noManMat, BorderLayout.CENTER);
      getContentPane().add(mouseMat, BorderLayout.NORTH);

      for(int i=5; i > 0;i--)
      {
         final int z= i;
         //playerCards.get(i).setText(this.playerHand.get(i));
         playerCards.get(i).setEnabled(true);
         //yogaMat.add(playerCards.get(i));

         class play implements ActionListener
         {
            public void actionPerformed(ActionEvent event)
            {
               System.out.println("Playing");//play(z);
            }

         }

         playerCards.get(i).addActionListener(new play());
      }
   
      /*for(int j=0; j < (this.computerHand.size());j++)
      {
         mouseMat.add(computerCards.get(j));
      }*/

      








      pack();




   }
}
