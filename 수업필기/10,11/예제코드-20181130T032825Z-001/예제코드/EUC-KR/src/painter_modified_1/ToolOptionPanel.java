package painter_modified_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * ������ ������ ����ϴ� �г�.
 */
public class ToolOptionPanel extends JPanel {
    public ToolOptionPanel(Canvas canvas) {
        this.canvas = canvas;

        setLayout(new GridLayout(3, 1));

        JComboBox<String> shapeComboBox = new JComboBox<>(new String[] {
                "���簢��",
                "�𼭸��� �ձ� ���簢��",
                "Ÿ��",
                "���̾Ƹ��"
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
                }
            }
        });
        add(shapeComboBox);

        JCheckBox fillOpt = new JCheckBox("���� ä���");
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

        // JComponent�� ��� Container�� ��ӹް� �ֱ� ������,
        // �ٸ� Component�� �Ǵٽ� ������ �� �ִ�.
        add(new ColorOptionPanel(canvas));
    }

    private Canvas canvas;
}
