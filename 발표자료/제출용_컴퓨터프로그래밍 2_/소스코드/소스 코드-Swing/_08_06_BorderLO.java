import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class BorderLO extends JFrame{
	
	BorderLO(){
		setTitle("BorderLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout(30, 40));
		
		add(new JButton("N"), BorderLayout.NORTH);
		add(new JButton("C"), BorderLayout.CENTER);
		add(new JButton("S"), BorderLayout.SOUTH);
		add(new JButton("E"), BorderLayout.EAST);
		add(new JButton("W"), BorderLayout.WEST);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BorderLO();
	}

}
