import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DoubleContainer extends JFrame{
	
	DoubleContainer(){
		setTitle("Double Container");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		
		JPanel P = new JPanel();
		P.add(new Label("New JPanel"));
		P.setBackground(Color.cyan);
		P.setSize(300, 300);
		
		add(P, "New JPanel");
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DoubleContainer();
	}
}
