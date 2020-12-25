package GUI_Swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class _08_07_GridLO extends JFrame{
	
	_08_07_GridLO(){
		setTitle("GridLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(3, 2));
		//cp.setLayout(new GridLayout(3, 2,20,40));
		
		cp.add(new JButton("1"));
		cp.add(new JButton("2"));
		cp.add(new JButton("3"));
		cp.add(new JButton("4"));
		cp.add(new JButton("5"));
		cp.add(new JButton("6"));
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new _08_07_GridLO();
	}

}