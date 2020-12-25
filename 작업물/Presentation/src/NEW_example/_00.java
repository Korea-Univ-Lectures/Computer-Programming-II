package NEW_example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class _00 extends JFrame {
	JPanel p1 =new JPanel();
	JTextField t1 =new JTextField("", 15);
	JTextField t2 =new JTextField("", 5);
	
	_00(){
		setTitle("Calculator");
		setSize(300,400);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		t2.setEnabled(false); //t2에 글씨쓰기를 막음
		
		p1.add(t1);
		p1.add(t2);
		
		add(p1, BorderLayout.NORTH);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new _00();
	}

}
