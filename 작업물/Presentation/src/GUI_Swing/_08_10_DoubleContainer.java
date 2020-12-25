package GUI_Swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class _08_10_DoubleContainer extends JFrame{
	
	_08_10_DoubleContainer(){
		setTitle("Double Container");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setLayout(null);
		
		JPanel P = new JPanel();
		
		P.add(new Label("New JPanel"));
		P.setBackground(Color.cyan);
		P.setLocation(0,0);
		P.setSize(100, 100);
		
		cp.add(P, "New JPanel");
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new _08_10_DoubleContainer();
	}
}
