package painter_modified_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * 색상과 관련된 옵션을 설정하는 패널.
 * ShapeOptionPanel에 삽입되는, 하위 컴포넌트이다.
 */
public class ColorOptionPanel extends JPanel {
    public ColorOptionPanel(Canvas canvas) {
        this.canvas = canvas;

        setLayout(new GridLayout(6, 1));

        ButtonGroup colorPreset = new ButtonGroup();

        customColorOpt = new JRadioButton("사용자 지정 색상", true);
        JRadioButton redColorOpt = new JRadioButton("빨강");
        JRadioButton greenColorOpt = new JRadioButton("초록");
        JRadioButton blueColorOpt = new JRadioButton("파랑");
        JRadioButton yellowColorOpt = new JRadioButton("노랑");

        customColorOpt.addItemListener(new CustomColorItemListener());
        // 사용자 지정 생성자를 활용하여, 동일한 리스너가 서로 다른 동작을 할 수 있도록 한다.
        redColorOpt.addItemListener(new FixedColorItemListener(255, 0, 0));
        greenColorOpt.addItemListener(new FixedColorItemListener(0, 255, 0));
        blueColorOpt.addItemListener(new FixedColorItemListener(0, 0, 255));
        yellowColorOpt.addItemListener(new FixedColorItemListener(255, 255, 0));

        // JRadioButton은 같은 그룹에 등록해야지만이 여러 선택지 중 한가지만 선택됨을 보장할 수 있다.
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
     * 사용자 지정 색상을 처리하는 리스너.
     * ItemListener와 ActionListener를 동시에 상속받고 있기 때문에,
     * JRadioButton과 JTextField의 리스너 역할을 동시에 수행할 수 있다.
     */
    private class CustomColorItemListener implements ItemListener, ActionListener {
        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            updateColor();
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            // 사용자 지정 색상 옵션이 선택되었을 때만 색상을 갱신하도록 한다.
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
