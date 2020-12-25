package GUI_Swing;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class _08_03_No_ContentPane extends JFrame {

	_08_03_No_ContentPane(){
		setTitle("JFrame_Extend");
		
		JButton b1=new JButton("1");
		JButton b2=new JButton("2");
		JButton b3=new JButton("3");
		
		setLayout(new FlowLayout());
		
		add(b1);
		add(b2);
		add(b3);
		
		setSize(400, 400);
		setVisible(true);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_08_03_No_ContentPane MainFrame = new _08_03_No_ContentPane();
		
	}

}
