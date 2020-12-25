package EventHandler;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class _09_03_Mouse extends JFrame {
	private JLabel la = new JLabel("Move Me"); 
	private JPanel pa = new JPanel();
	
	public _09_03_Mouse() {
		setTitle("MouseListener와 MouseMotionListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		MyMouseListener listener = new MyMouseListener(); 			
		addMouseListener(listener); 
		addMouseMotionListener(listener); 
		
		setLayout(null);
		
		la.setSize(80,20);
		la.setLocation(100,80);
		add(la); // 레이블 컴포넌트 삽입
		
		pa.setSize(600,400);
		pa.setLocation(0,0);
		add(pa);
		
		setSize(600,400);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {
		public void mousePressed(MouseEvent e) {
			la.setLocation(e.getX(), e.getY()); 
			setTitle("mousePressed("+e.getX()+","+e.getY()+")"); 
		}
		public void mouseReleased(MouseEvent e) {
			la.setLocation(e.getX(), e.getY()); 
			setTitle("mouseReleased("+e.getX()+","+e.getY()+")"); 
		}
		public void mouseClicked(MouseEvent e) {}
		
		public void mouseEntered(MouseEvent e) {
			pa.setBackground(Color.CYAN);
		}
		public void mouseExited(MouseEvent e) {
			pa.setBackground(Color.yellow);
			setTitle("mouseExited("+e.getX()+","+e.getY()+")");
		}
		public void mouseDragged(MouseEvent e) { 
			la.setLocation(e.getX(), e.getY());
			setTitle("mouseDragged("+e.getX()+","+e.getY()+")"); 
		}
		public void mouseMoved(MouseEvent e) { 
			la.setLocation(e.getX(), e.getY());
			setTitle("mouseMoved ("+e.getX()+","+e.getY()+")"); 
		}
	}

	
	public static void main(String[] args) {
		new _09_03_Mouse();

	}

}
