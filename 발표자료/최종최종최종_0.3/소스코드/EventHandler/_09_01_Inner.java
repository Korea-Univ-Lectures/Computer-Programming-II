package EventHandler;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class _09_01_Inner extends JFrame {
	
	public _09_01_Inner() {
		setTitle("Action �̺�Ʈ ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener()); 
		
		add(btn);
		setSize(250, 120);
		setVisible(true);
	}
	
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action"))
				b.setText("�׼�");
			else
				b.setText("Action");
			
			// MyActionListener�� ����� JFrame�� ����� ȣ��
			_09_01_Inner.this.setTitle(b.getText()); // Ÿ��Ʋ�� ��ư ���ڿ��� ���
		}
	}	
	public static void main(String [] args) {
		new _09_01_Inner();
	}
}

