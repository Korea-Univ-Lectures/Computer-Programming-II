package NEW_example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class _01_Awnser extends JFrame{
	JPanel p1 =new JPanel();
	JPanel p2 =new JPanel();//JPanel 추가
	JTextField t1 =new JTextField("", 15);
	JTextField t2 =new JTextField("", 5);
	JButton Button[] = new JButton[16];
	
	_01_Awnser(){
		setTitle("Calculator");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 400);
		
		t2.setEnabled(false); 
		
		p1.add(t1);
		p1.add(t2);
		
		p2.setLayout(new GridLayout(4, 4, 10, 10));
		
		//16개의 버튼의 이름에 들어갈 배열
		String ButtonValue[] = { "1", "2", "3", "X", "4", "5", "6", "/", "7", "8", "9", "+", "C", "0", "=", "-" };
		
		for (int i = 0; i <= 15; i++) {
			Button[i] = new JButton(ButtonValue[i]);
			p2.add(Button[i]);
		}
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new _01_Awnser();
	}

}
