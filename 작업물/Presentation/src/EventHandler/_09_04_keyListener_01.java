package EventHandler;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class _09_04_keyListener_01 extends JFrame{
	JPanel pa1 = new JPanel();
	JLabel la1 = new JLabel();
	JLabel la2 = new JLabel();
	
	_09_04_keyListener_01(){
		
		pa1.setLayout(null);
		la1.setLocation(20,20);
		la1.setSize(120, 15);
		la1.setText("문자 키: ");
		
		la2.setLocation(20,50);
		la2.setSize(120, 15);
		la2.setText("기능 키: ");
		
		pa1.add(la1);
		pa1.add(la2);
		pa1.addKeyListener(new myKeyListener());
		
		pa1.setFocusable(true);
		pa1.requestFocus(true);
		
		setTitle("키 입력");
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(pa1);
	}
	class myKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			char c= e.getKeyChar();
			
			if(c==KeyEvent.CHAR_UNDEFINED) 
				la2.setText("기능 키: "+e.getKeyText(e.getKeyCode()));
			else {
				String s = "문자 키: "+c;
				la1.setText(s);}
		}
	}

	public static void main(String[] args) {
		new _09_04_keyListener_01();

	}

}
