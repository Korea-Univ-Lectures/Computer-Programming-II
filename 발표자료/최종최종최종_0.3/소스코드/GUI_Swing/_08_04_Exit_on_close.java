package GUI_Swing;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class _08_04_Exit_on_close extends JFrame {

	_08_04_Exit_on_close(){
		setTitle("JFrame_Extend");
		
		JButton b1=new JButton("1");
		JButton b2=new JButton("2");
		JButton b3=new JButton("3");
		
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		
		cp.add(b1);
		cp.add(b2);
		cp.add(b3);
		
		setSize(400, 400);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		_08_04_Exit_on_close MainFrame = new _08_04_Exit_on_close();
	}

}
