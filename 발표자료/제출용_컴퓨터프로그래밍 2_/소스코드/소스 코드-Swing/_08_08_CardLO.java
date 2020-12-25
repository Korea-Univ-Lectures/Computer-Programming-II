import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class CardLO{
	
	CardLO(){
		Frame f = new Frame("CardLayout");
		CardLayout card = new CardLayout(10, 10);
		f.setLayout(card);
		
		Panel card1 = new Panel();
		card1.add(new Label("Card 1"));
		card1.setBackground(Color.red);
		Panel card2 = new Panel();
		card2.add(new Label("Card 2"));
		card2.setBackground(Color.blue);
		Panel card3 = new Panel();
		card3.add(new Label("Card 3"));
		card3.setBackground(Color.yellow);
		
		f.add(card1, "1");
		f.add(card2, "2");
		f.add(card3, "3");
		
		class Handler extends MouseAdapter{
			public void mouseClicked (MouseEvent e) {
				if (e.getModifiers() == e.BUTTON3_MASK) {
					card.previous(f);
				}
				else {
					card.next(f);
				}
			}
		}
		
		card1.addMouseListener(new Handler());
		card2.addMouseListener(new Handler());
		card3.addMouseListener(new Handler());
		
		
		f.setSize(200, 200);
		f.setLocation(200, 200);
		f.setVisible(true);
		
		card.show(f, "1");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CardLO();
	}

}
