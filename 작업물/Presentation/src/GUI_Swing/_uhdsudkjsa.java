package GUI_Swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class _uhdsudkjsa extends JFrame {
	_uhdsudkjsa(){
		setTitle("Hello");
		setSize(200, 300);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		JButton b1 =new JButton("1");
		JButton b2 =new JButton("2");
		
		cp.add(b1, BorderLayout.NORTH);
		cp.add(b2, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		_uhdsudkjsa dj =new _uhdsudkjsa();
	}

}
