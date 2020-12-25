package GUI_Swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class _08_09_NullLO extends JFrame{
	
	_08_09_NullLO(){
		setTitle("Null");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setLayout(null);
		
		for (int i = 1; i <= 9; i++) {
			JTextField b = new JTextField(10);
			b.setText(Integer.toString(i));
			b.setLocation(i*15, i*15);
			b.setSize(50, 20);
			//b.setBounds(i*15, i*15,50, 20);
			cp.add(b);
		}
		
		setSize(300, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new _08_09_NullLO();
	}

}
