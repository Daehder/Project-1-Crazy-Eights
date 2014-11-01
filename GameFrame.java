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
   private JButton deckButton, card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14;
   private JButton card15, card16, card17, card18, card19, card20, card21, card22, card23, card24, card25, card26, card27, card28, card29, card30;
   private JButton card31, card32, card33, card34, card35, card36, card37, card38, card39, card40, card41, card42, card43, card44, card45;
   private JButton card46, card47, card48, card49, card50, card51, card52;
   private ArrayList<JButton> playerCards, computerCards;
   private LQueue<JButton> freeCards;
   private Hand playerHand, computerHand;
   
   private Card lastCard;
   private Deck deck;

   public GameFrame(CrazyEightsGame game) 
   {
		this(game.getHand(1), game.getHand(2), game.getDeck(), game.getLastCard());
	}

   public GameFrame(Hand playerHand, Hand computerHand, Deck deck, Card lastCard)
   {
      this.playerHand= playerHand;
      this.computerHand= computerHand;
      this.deck= deck;
      this.lastCard= lastCard;
         	
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
      card15= new JButton("");
      card16= new JButton("");
      card17= new JButton("");
      card18= new JButton("");
      card19= new JButton("");
      card20= new JButton("");
      card21= new JButton("");
      card22= new JButton("");
      card23= new JButton("");
      card24= new JButton("");
      card25= new JButton("");
      card26= new JButton("");
      card27= new JButton("");
      card28= new JButton("");
      card29= new JButton("");
      card30= new JButton("");
      card31= new JButton("");
      card32= new JButton("");
      card33= new JButton("");
      card34= new JButton("");
      card35= new JButton("");
      card36= new JButton("");
      card37= new JButton("");
      card38= new JButton("");
      card39= new JButton("");
      card40= new JButton("");
      card41= new JButton("");
      card42= new JButton("");
      card43= new JButton("");
      card44= new JButton("");
      card45= new JButton("");
      card46= new JButton("");
      card47= new JButton("");
      card48= new JButton("");
      card49= new JButton("");
      card50= new JButton("");
      card51= new JButton("");
      card52= new JButton("");
      
                        

      playerCards= new ArrayList<JButton>();
      playerCards.add(card1);
      playerCards.add(card2);
      playerCards.add(card3);
      playerCards.add(card4);
      playerCards.add(card5);
      playerCards.add(card6);
      playerCards.add(card7);
      playerCards.add(card8);

      computerCards= new ArrayList<JButton>();
      computerCards.add(card9);
      computerCards.add(card10);
      computerCards.add(card11);
      computerCards.add(card12);
      computerCards.add(card13);
      computerCards.add(card14);
      computerCards.add(card15);
      computerCards.add(card16);
      
      freeCards= new LQueue<JButton>();
      freeCards.enqueue(card17);
      freeCards.enqueue(card18);
      freeCards.enqueue(card19);
      freeCards.enqueue(card20);
      freeCards.enqueue(card21);
      freeCards.enqueue(card22);
      freeCards.enqueue(card23);
      freeCards.enqueue(card24);
      freeCards.enqueue(card25);
      freeCards.enqueue(card26);
      freeCards.enqueue(card27);
      freeCards.enqueue(card28);
      freeCards.enqueue(card29);
      freeCards.enqueue(card30);
      freeCards.enqueue(card31);
      freeCards.enqueue(card32);
      freeCards.enqueue(card33);
      freeCards.enqueue(card34);
      freeCards.enqueue(card35);
      freeCards.enqueue(card36);
      freeCards.enqueue(card37);
      freeCards.enqueue(card38);
      freeCards.enqueue(card39);
      freeCards.enqueue(card40);
      freeCards.enqueue(card41);
      freeCards.enqueue(card42);
      freeCards.enqueue(card43);
      freeCards.enqueue(card44);
      freeCards.enqueue(card45);
      freeCards.enqueue(card46);
      freeCards.enqueue(card47);
      freeCards.enqueue(card48);
      freeCards.enqueue(card49);
      freeCards.enqueue(card50);
      freeCards.enqueue(card51);
      freeCards.enqueue(card52);
      
      
      yogaMat= new JPanel();
      yogaMat.setPreferredSize(new Dimension(800, 150));
      yogaMat.setBorder(BorderFactory.createEtchedBorder());
      yogaMat.setLayout(new GridLayout(5, 1));

      noManMat= new JPanel();
      noManMat.setPreferredSize(new Dimension(800, 150));
      noManMat.setBorder(BorderFactory.createEtchedBorder());
      noManMat.setLayout(new GridLayout(5, 1));

      mouseMat= new JPanel();
      mouseMat.setPreferredSize(new Dimension(800, 150));
      mouseMat.setBorder(BorderFactory.createEtchedBorder());
      mouseMat.setLayout(new GridLayout(1, playerHand.size()));

      getContentPane().add(yogaMat, BorderLayout.SOUTH);
      getContentPane().add(noManMat, BorderLayout.CENTER);
      getContentPane().add(mouseMat, BorderLayout.NORTH);

      for(int i=0; i < 8;i++)
      {
         final int z= i;
         playerCards.get(i).setText((this.playerHand.get(i)).toString());
         playerCards.get(i).setEnabled(true);
         yogaMat.add(playerCards.get(i));

         class play implements ActionListener
         {
            public void actionPerformed(ActionEvent event)
            {
               System.out.println("Playing");//play(z);
            }

         }

         playerCards.get(i).addActionListener(new play());
      }
      //System.out.println(computerCards.size());
      //System.out.println(this.computerHand.size());
      //System.out.println("Adding Computer Cards");
      
      for(int j=0; j < 8;j++)
      {
         //System.out.println("RoundME:"+j);
         //System.out.println((this.computerHand.get(j)).toString());
         //(computerCards.get(j)).setText((this.computerHand.get(j)).toString());
         //System.out.println("RoundME:"+j+".5");
         computerCards.get(j).setEnabled(false);
         mouseMat.add(computerCards.get(j));
      }
      
      pack();




   }
}

