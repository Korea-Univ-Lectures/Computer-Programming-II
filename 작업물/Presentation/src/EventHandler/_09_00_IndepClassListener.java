package EventHandler;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class _09_00_IndepClassListener extends JFrame {
	public _09_00_IndepClassListener() {
		
		setTitle("Action �̺�Ʈ ������ ����");
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
// ������ Ŭ������ �̺�Ʈ �����ʸ� �ۼ��Ѵ�.

class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JButton b =(JButton)e.getSource();
		System.out.println("Hello");
	}
}

