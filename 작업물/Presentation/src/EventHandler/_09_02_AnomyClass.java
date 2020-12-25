package EventHandler;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class _09_02_AnomyClass extends JFrame{
	
	public _09_02_AnomyClass() {
		setTitle("Action 이벤트 리스너 작성");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		add(btn);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				System.out.println("Hello World");
				
				
			}
		});

		setSize(350, 150);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		_09_02_AnomyClass a =new _09_02_AnomyClass();
	}

}
