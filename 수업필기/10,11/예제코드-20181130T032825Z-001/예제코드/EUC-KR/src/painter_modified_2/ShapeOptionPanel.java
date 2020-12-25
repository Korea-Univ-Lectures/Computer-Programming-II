package painter_modified_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ShapeOptionPanel extends JPanel {
    public ShapeOptionPanel(Canvas canvas) {
        this.canvas = canvas;

        setLayout(new GridLayout(3, 1));

        JComboBox<String> shapeComboBox = new JComboBox<>(new String[] {
                "직사각형",
                "모서리가 둥근 직사각형",
                "타원",
                "다이아몬드",
                "직각삼각형"
        });
        shapeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> comboBox = (JComboBox<String>)(e.getSource());
                int selected = comboBox.getSelectedIndex();
                switch (selected) {
                    case 0:
                        canvas.changeTool(Canvas.Shape.RECT);
                        break;
                    case 1:
                        canvas.changeTool(Canvas.Shape.ROUNDED_RECT);
                        break;
                    case 2:
                        canvas.changeTool(Canvas.Shape.OVAL);
                        break;
                    case 3:
                        canvas.changeTool(Canvas.Shape.DIAMOND);
                        break;
                    case 4:
                        canvas.changeTool(Canvas.Shape.TRIANGLE);
                        break;
                }
            }
        });
        add(shapeComboBox);

        JCheckBox fillOpt = new JCheckBox("안을 채우기");
        fillOpt.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (ItemEvent.SELECTED == itemEvent.getStateChange()) {
                    canvas.setFillMode(true);
                }
                else {
                    canvas.setFillMode(false);
                }
            }
        });
        add(fillOpt);

        add(new LineOptionPanel(canvas));
    }

    private Canvas canvas;
}
