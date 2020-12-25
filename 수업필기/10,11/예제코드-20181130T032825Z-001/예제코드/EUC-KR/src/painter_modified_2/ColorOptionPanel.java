package painter_modified_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * ����� ���õ� �ɼ��� �����ϴ� �г�.
 * ShapeOptionPanel�� ���ԵǴ�, ���� ������Ʈ�̴�.
 */
public class ColorOptionPanel extends JPanel {
    public ColorOptionPanel(Canvas canvas) {
        this.canvas = canvas;

        setLayout(new GridLayout(6, 1));

        ButtonGroup colorPreset = new ButtonGroup();

        customColorOpt = new JRadioButton("����� ���� ����", true);
        JRadioButton redColorOpt = new JRadioButton("����");
        JRadioButton greenColorOpt = new JRadioButton("�ʷ�");
        JRadioButton blueColorOpt = new JRadioButton("�Ķ�");
        JRadioButton yellowColorOpt = new JRadioButton("���");

        customColorOpt.addItemListener(new CustomColorItemListener());
        // ����� ���� �����ڸ� Ȱ���Ͽ�, ������ �����ʰ� ���� �ٸ� ������ �� �� �ֵ��� �Ѵ�.
        redColorOpt.addItemListener(new FixedColorItemListener(255, 0, 0));
        greenColorOpt.addItemListener(new FixedColorItemListener(0, 255, 0));
        blueColorOpt.addItemListener(new FixedColorItemListener(0, 0, 255));
        yellowColorOpt.addItemListener(new FixedColorItemListener(255, 255, 0));

        // JRadioButton�� ���� �׷쿡 ����ؾ������� ���� ������ �� �Ѱ����� ���õ��� ������ �� �ִ�.
        colorPreset.add(customColorOpt);
        colorPreset.add(redColorOpt);
        colorPreset.add(greenColorOpt);
        colorPreset.add(blueColorOpt);
        colorPreset.add(yellowColorOpt);

        add(customColorOpt);
        add(redColorOpt);
        add(greenColorOpt);
        add(blueColorOpt);
        add(yellowColorOpt);

        JPanel customColor = new JPanel();

        rChannel = new JTextField("0", 3);
        gChannel = new JTextField("0", 3);
        bChannel = new JTextField("0", 3);

        rChannel.addActionListener(new CustomColorItemListener());
        gChannel.addActionListener(new CustomColorItemListener());
        bChannel.addActionListener(new CustomColorItemListener());

        customColor.add(new Label("R:"));
        customColor.add(rChannel);
        customColor.add(new Label("G:"));
        customColor.add(gChannel);
        customColor.add(new Label("B:"));
        customColor.add(bChannel);
        add(customColor);
    }

    /**
     * ����� ���� ������ ó���ϴ� ������.
     * ItemListener�� ActionListener�� ���ÿ� ��ӹް� �ֱ� ������,
     * JRadioButton�� JTextField�� ������ ������ ���ÿ� ������ �� �ִ�.
     */
    private class CustomColorItemListener implements ItemListener, ActionListener {
        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            updateColor();
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // ����� ���� ���� �ɼ��� ���õǾ��� ���� ������ �����ϵ��� �Ѵ�.
            if (customColorOpt.isSelected()) {
                updateColor();
            }
        }

        private void updateColor() {
            int r = Integer.parseInt(rChannel.getText());
            int g = Integer.parseInt(gChannel.getText());
            int b = Integer.parseInt(bChannel.getText());
            canvas.changeColor(new Color(r, g, b));
        }
    }

    private class FixedColorItemListener implements ItemListener {
        private int r, g, b;

        public FixedColorItemListener(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            canvas.changeColor(new Color(r, g, b));
        }
    }

    private Canvas canvas;
    private JTextField rChannel, gChannel, bChannel;

    private JRadioButton customColorOpt;
}
