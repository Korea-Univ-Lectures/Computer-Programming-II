package EventHandler;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class _09_01_Inner extends JFrame {
	
	public _09_01_Inner() {
		setTitle("Action 이벤트 리스너 예제");
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
				b.setText("액션");
			else
				b.setText("Action");
			
			// MyActionListener의 멤버나 JFrame의 멤버를 호출
			_09_01_Inner.this.setTitle(b.getText()); // 타이틀에 버튼 문자열을 출력
		}
	}	
	public static void main(String [] args) {
		new _09_01_Inner();
	}
}

