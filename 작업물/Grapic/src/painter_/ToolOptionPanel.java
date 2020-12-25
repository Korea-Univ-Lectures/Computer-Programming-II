package painter_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * �룄援ъ쓽 �꽕�젙�쓣 �떞�떦�븯�뒗 �뙣�꼸.
 */
public class ToolOptionPanel extends JPanel {
    public ToolOptionPanel(Canvas canvas) {
        this.canvas = canvas;

        setLayout(new GridLayout(3, 1));

        JComboBox<String> shapeComboBox = new JComboBox<>(new String[] {
                "吏곸궗媛곹삎",
                "紐⑥꽌由ш� �뫁洹� 吏곸궗媛곹삎",
                "���썝",
                "�떎�씠�븘紐щ뱶"
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

        JCheckBox fillOpt = new JCheckBox("�븞�쓣 梨꾩슦湲�");
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

        // JComponent�뒗 紐⑤몢 Container瑜� �긽�냽諛쏄퀬 �엳湲� �븣臾몄뿉,
        // �떎瑜� Component瑜� �삉�떎�떆 �룷�븿�븷 �닔 �엳�떎.
        add(new ColorOptionPanel(canvas));
    }

    private Canvas canvas;
}
