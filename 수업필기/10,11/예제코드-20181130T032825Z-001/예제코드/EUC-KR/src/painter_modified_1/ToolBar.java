package painter_modified_1;

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

        JButton lineToolButton = new JButton(lineToolIcon);
        JButton shapeToolButton = new JButton(shapeToolIcon);
        JButton eraseAllButton = new JButton(eraseAllToolIcon);

        lineToolButton.addActionListener(new LineToolListener());
        shapeToolButton.addActionListener(new ShapeToolListener());
        eraseAllButton.addActionListener(new EraseAllListener());

        add(lineToolButton);
        add(shapeToolButton);
        add(eraseAllButton);
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

    private Canvas canvas;
}
