package EventHandler;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class _09_00_IndepClassListener extends JFrame {
	public _09_00_IndepClassListener() {
		
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener());
		
		add(btn);
		setSize(250, 120);
		setVisible(true);
	}
	public static void main(String [] args) {
		new _09_00_IndepClassListener();
	}
}
// 독립된 클래스로 이벤트 리스너를 작성한다.

class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JButton b =(JButton)e.getSource();
		System.out.println("Hello");
	}
}

