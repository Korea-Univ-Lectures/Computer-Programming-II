package painter_modified_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class LineOptionPanel extends JPanel {
    public LineOptionPanel(Canvas canvas) {
        this.canvas = canvas;

        setLayout(new GridLayout(6, 1));

        ButtonGroup colorPreset = new ButtonGroup();

        JRadioButton customColorOpt = new JRadioButton("»ç¿ëÀÚ ÁöÁ¤ »ö»ó", true);
        JRadioButton redColorOpt = new JRadioButton("»¡°­");
        JRadioButton greenColorOpt = new JRadioButton("ÃÊ·Ï");
        JRadioButton blueColorOpt = new JRadioButton("ÆÄ¶û");
        JRadioButton yellowColorOpt = new JRadioButton("³ë¶û");

        customColorOpt.addItemListener(new FixedColorItemListener(0, 0, 0));
        redColorOpt.addItemListener(new FixedColorItemListener(255, 0, 0));
        greenColorOpt.addItemListener(new FixedColorItemListener(0, 255, 0));
        blueColorOpt.addItemListener(new FixedColorItemListener(0, 0, 255));
        yellowColorOpt.addItemListener(new FixedColorItemListener(255, 255, 0));

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

    private class CustomColorItemListener implements ItemListener, ActionListener {
        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            updateColor();
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            updateColor();
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
}
