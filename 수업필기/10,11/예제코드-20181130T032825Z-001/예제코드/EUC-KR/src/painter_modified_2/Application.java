package painter_modified_2;

import javax.swing.*;
import java.awt.*;

/**
 * Painter ���� �� �޴� ���̾ƿ��� ����
 * �����Ͻ� ������ �ٸ� Ŭ����(�ַ� Canvas)���� ó���ȴ�.
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

        // �׸��� �׸��µ� ���Ǵ� Canvas�� �߾ӿ� ��ġ�Ѵ�.
        // ���� ������Ʈ���� canvasPanel�� �ʱ�ȭ ������ ����ϹǷ�,
        // canvasPanel�� �ݵ�� ���� ���� �ʱ�ȭ�Ǿ�� �Ѵ�.
        canvasPanel = new Canvas(this);
        contentPane.add(canvasPanel, BorderLayout.CENTER);

        // ����(���� ����, ���� ����) ��ư�� ��ġ�Ǿ��ִ� ToolBar�� ���ʿ� ��ġ�Ѵ�.
        toolPanel = new ToolBar(canvasPanel);
        contentPane.add(toolPanel, BorderLayout.NORTH);

        // ������ ���� ������ �����ϴ� ShapeOptionPanel�� ���ʿ� ��ġ�Ѵ�.
        shapeOptionPanel = new ToolOptionPanel(canvasPanel);
        contentPane.add(shapeOptionPanel, BorderLayout.EAST);

        setJMenuBar(new MenuBar(canvasPanel));

        validate();
    }
}
