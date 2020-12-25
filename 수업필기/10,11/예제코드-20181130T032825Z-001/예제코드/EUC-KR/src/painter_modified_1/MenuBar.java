package painter_modified_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * �޴��ٸ� ��Ÿ���� Ŭ����.
 */
public class MenuBar extends JMenuBar {

	public MenuBar(Canvas canvas){
		super();

		this.canvas = canvas;

		// MenuBar, Menu, MenuItem ������ ����� �̷������.
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
			// getActionCommand() �Լ��� ��ȯ�ϴ� �޴� �������� ��Ī�� �����
			// � ����� �����Ͽ����� ������ �� �ִ�.
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
