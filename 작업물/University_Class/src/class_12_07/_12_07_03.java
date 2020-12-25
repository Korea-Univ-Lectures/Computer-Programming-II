package class_12_07;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class Mylabel extends JLabel{
	private int barSize=0;
	private int maxBarSize;
	
	Mylabel (int maxBarSize){
		this.maxBarSize=maxBarSize;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.MAGENTA);
		int width=(int)((double)(this.getWidth()))/maxBarSize*barSize;
		if(width==0) return;
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	syn
}

public class _12_07_03 {

}
