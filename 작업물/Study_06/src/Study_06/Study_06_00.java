package Study_06;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Study_06_00 extends JFrame{
	
	public Study_06_00(){
		setTitle("Double Container");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel P = new JPanel();
		P.add(new Label("New JPanel"));
		P.setBackground(Color.cyan);
		P.setSize(300, 300);
		
		add(P, BorderLayout.NORTH);
		
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		Study_06_00 s = new Study_06_00();

	}

}
