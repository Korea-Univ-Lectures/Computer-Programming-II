package NEW_example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class _01 extends JFrame{
	JPanel p1 =new JPanel();
	JTextField t1 =new JTextField("", 15);
	JTextField t2 =new JTextField("", 5);
	
	_01(){
		setTitle("Calculator");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		
		t2.setEnabled(false); 
		
		p1.add(t1);
		p1.add(t2);
		
		//16개의 버튼의 이름에 들어갈 배열
		String ButtonValue[] = { "1", "2", "3", "X", "4", "5", "6", "/", "7", "8", "9", "+", "C", "0", "=", "-" };
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new _01();
	}

}
