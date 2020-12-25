package painter_modified_2;

import javax.swing.*;
import java.awt.*;

/**
 * Painter 앱의 주 메뉴 레이아웃을 결정
 * 비지니스 로직은 다른 클래스(주로 Canvas)에서 처리된다.
 */
public class Application extends JFrame {
    private final int width = 700;
    private final int height = 700;

    private ToolBar toolPanel;
    private JPanel shapeOptionPanel;
    private Canvas canvasPanel;

    public Application() {
        setTitle("Painter");
        setSize(width, height);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        // 그림을 그리는데 사용되는 Canvas를 중앙에 배치한다.
        // 이후 컴포넌트들은 canvasPanel을 초기화 과정에 사용하므로,
        // canvasPanel이 반드시 가장 먼저 초기화되어야 한다.
        canvasPanel = new Canvas(this);
        contentPane.add(canvasPanel, BorderLayout.CENTER);

        // 도구(직선 도구, 도형 도구) 버튼이 배치되어있는 ToolBar를 북쪽에 배치한다.
        toolPanel = new ToolBar(canvasPanel);
        contentPane.add(toolPanel, BorderLayout.NORTH);

        // 도구의 세부 설정을 조정하는 ShapeOptionPanel을 동쪽에 배치한다.
        shapeOptionPanel = new ToolOptionPanel(canvasPanel);
        contentPane.add(shapeOptionPanel, BorderLayout.EAST);

        setJMenuBar(new MenuBar(canvasPanel));

        validate();
    }
}
