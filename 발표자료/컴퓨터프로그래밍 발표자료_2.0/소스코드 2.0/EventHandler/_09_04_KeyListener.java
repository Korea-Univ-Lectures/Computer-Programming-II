package EventHandler;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class _09_04_KeyListener extends JFrame {
	private JLabel la = new JLabel("<Enter>Ű�� ������ �ٲ�ϴ�");
	
	public _09_04_KeyListener() {
		super("KeyListener�� ���� Ű �Է� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane(); 
		c.setLayout(new FlowLayout());
		c.add(la);
		
		c.addKeyListener(new MyKeyListener()); 
		
		setSize(250, 150);
		setVisible(true);
		
		c.setFocusable(true); // ����Ʈ���� ��Ŀ���� ���� �� �ֵ��� ����
		c.requestFocus(); // ����Ʈ�ҿ� ��Ŀ�� ����
	}
	
	class MyKeyListener extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			// ������ ���� ����� ���� �����ϰ� r, g, b ���� ����
			int r = (int) (Math.random() * 256); // red ����
			int g = (int) (Math.random() * 256); // green ����
			int b = (int) (Math.random() * 256); // blue ����
			
			switch(e.getKeyChar()) { // �Էµ� Ű ����
				case '\n': // <Enter> Ű �Է�
					la.setText("r=" + r + ", g=" + g + ", b=" + b);
					getContentPane().setBackground(new Color(r, g, b)); 
					if(e.getKeyCode()==KeyEvent.VK_ENTER)
					break;
					
				case 'q':
					System.exit(0); 
					break;
					
				default:
					System.out.println(e.getKeyChar());
					System.out.println(e.getKeyCode());
					System.out.println(e.getKeyText(e.getKeyCode()));
			}
		}
	}

	public static void main(String[] args) {
		new _09_04_KeyListener();
	}

}
