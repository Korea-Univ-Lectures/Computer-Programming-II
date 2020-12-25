package EventHandler;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class _09_05_getActionCommans extends JFrame{
	JButton b1 = new JButton("Hello");
	JButton b2 = new JButton("Bye");
	JButton b3 = new JButton("Hi");
	
	class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String input = e.getActionCommand();
			System.out.println("눌린버튼 이름은 "+input+"입니다.");
		}
	}
	
	_09_05_getActionCommans(){
		setTitle("버튼 이름");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b1.addActionListener(new MyListener());
		b2.addActionListener(new MyListener());
		b3.addActionListener(new MyListener());
		
		setLayout(new FlowLayout());
		
		add(b1);
		add(b2);
		add(b3);
		
		setSize(300, 400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new _09_05_getActionCommans();
	}

}
