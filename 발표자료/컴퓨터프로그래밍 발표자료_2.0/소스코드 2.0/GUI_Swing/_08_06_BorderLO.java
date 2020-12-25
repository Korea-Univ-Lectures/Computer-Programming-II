package GUI_Swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class _08_06_BorderLO extends JFrame{

	_08_06_BorderLO(){
		setTitle("BorderLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		//cp.setLayout(new BorderLayout(30, 40));
		
		cp.add(new JButton("N"), BorderLayout.NORTH);
		cp.add(new JButton("C"), BorderLayout.CENTER);
		cp.add(new JButton("S"), BorderLayout.SOUTH);
		cp.add(new JButton("E"), BorderLayout.EAST);
		cp.add(new JButton("W"), BorderLayout.WEST);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new _08_06_BorderLO();
	}

}
