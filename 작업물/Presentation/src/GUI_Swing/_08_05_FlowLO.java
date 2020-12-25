package GUI_Swing;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class _08_05_FlowLO extends JFrame{

	_08_05_FlowLO(){
		setTitle("FlowLayout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		//cp.setLayout(new FlowLayout());
		cp.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		
		cp.add(new JButton("1"));
		cp.add(new JButton("2"));
		cp.add(new JButton("3"));
		cp.add(new JButton("4"));
		cp.add(new JButton("5"));
		cp.add(new JButton("6"));
		
		setSize(900, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new _08_05_FlowLO();
	}

}
