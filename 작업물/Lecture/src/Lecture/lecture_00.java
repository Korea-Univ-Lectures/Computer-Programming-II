package Lecture;


import java.awt.*;

import javax.swing.*;

public class lecture_00 extends JFrame{
	public lecture_00() {
		JFrame f = new JFrame();
		f.setTitle("Swing ¿¬½À");
		f.setSize(200,200);
		f.setVisible(true);
		
		f.setLayout(new BorderLayout());
		f.add(new JButton("NORTH"),BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		lecture_00 l =new lecture_00();
	}
}
