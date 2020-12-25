package painter_modified_3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 메뉴바를 나타내는 클래스.
 */
public class MenuBar extends JMenuBar {

	public MenuBar(Canvas canvas){
		super();

		this.canvas = canvas;

		// MenuBar, Menu, MenuItem 순으로 등록이 이루어진다.
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
			// getActionCommand() 함수가 반환하는 메뉴 아이템의 명칭을 사용해
			// 어떤 명령을 선택하였는지 구분할 수 있다.
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
