package painter_;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 硫붾돱諛붾�� �굹���궡�뒗 �겢�옒�뒪.
 */
public class MenuBar extends JMenuBar {

	public MenuBar(Canvas canvas){
		super();

		this.canvas = canvas;

		// MenuBar, Menu, MenuItem �닚�쑝濡� �벑濡앹씠 �씠猷⑥뼱吏꾨떎.
		JMenu editMenu = new JMenu("Edit");
		JMenuItem clearItem = new JMenuItem("Clear");
		JMenuItem undoItem = new JMenuItem("Undo");
		clearItem.addActionListener(new MenuListener());
		undoItem.addActionListener(new MenuListener());
		editMenu.add(clearItem);
		editMenu.add(undoItem);
		add(editMenu);
	}
	
	private class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// getActionCommand() �븿�닔媛� 諛섑솚�븯�뒗 硫붾돱 �븘�씠�뀥�쓽 紐낆묶�쓣 �궗�슜�빐
			// �뼱�뼡 紐낅졊�쓣 �꽑�깮�븯���뒗吏� 援щ텇�븷 �닔 �엳�떎.
			String action = e.getActionCommand();
			switch(action) {
			case "Clear":
				canvas.clear();
				break;
				
			case "Undo":
				canvas.undo();
				break;
			}	
		}
	}

	private Canvas canvas;
}
