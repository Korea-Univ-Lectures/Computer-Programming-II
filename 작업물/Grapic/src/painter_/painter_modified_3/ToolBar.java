package painter_modified_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel {
    public ToolBar(Canvas canvas) {
        super();

        this.canvas = canvas;

        setBackground(Color.GRAY);

        ImageIcon lineToolIcon = new ImageIcon("images/line_tool.png");
        ImageIcon shapeToolIcon = new ImageIcon("images/shape_tool.png");
        ImageIcon eraseAllToolIcon = new ImageIcon("images/erase_all_tool.png");
        ImageIcon imageToolIcon = new ImageIcon("images/image_tool.png");

        JButton lineToolButton = new JButton(lineToolIcon);
        JButton shapeToolButton = new JButton(shapeToolIcon);
        JButton eraseAllButton = new JButton(eraseAllToolIcon);
        JButton imageToolButton = new JButton(imageToolIcon);

        lineToolButton.addActionListener(new LineToolListener());
        shapeToolButton.addActionListener(new ShapeToolListener());
        eraseAllButton.addActionListener(new EraseAllListener());
        imageToolButton.addActionListener(new ImageToolListener());

        add(lineToolButton);
        add(shapeToolButton);
        add(eraseAllButton);
	add(imageToolButton);
    }

    private class LineToolListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            canvas.changeTool(Canvas.Shape.LINE);
        }
    }

    private class ShapeToolListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            canvas.changeTool(Canvas.Shape.RECT);
        }
    }

    private class EraseAllListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int respond = JOptionPane.showConfirmDialog(null,"화면을 지우겠습니까?",
                    "화면 지우기", JOptionPane.YES_NO_OPTION);
            if (respond == JOptionPane.YES_OPTION) {
                canvas.clear();
            }
        }
    }

    private class ImageToolListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            canvas.changeTool(Canvas.Shape.FIXED_IMAGE);
        }
    }

    private Canvas canvas;
}
