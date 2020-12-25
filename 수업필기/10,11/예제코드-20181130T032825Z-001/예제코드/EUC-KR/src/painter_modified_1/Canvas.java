package painter_modified_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * ������ �׸��� �׷����� �� ������ ��Ÿ���� Ŭ����.
 * �� ������ ���� �Է°� �׸��� �׸��� ó���� ������ �����Ѵ�.
 */
public class Canvas extends JPanel {
    public Canvas(Application app) {
        super();

        // ���콺 ���ۿ� �ش��ϴ� �����ʸ� ����Ѵ�. �� �κ��� �� ������ �Է��� �־����� ������
        // Drawable ��ü�� �߰��ϴ� ������ ����Ѵ�.
        addMouseListener(new DrawMouseAdapter());
        addMouseMotionListener(new DrawMouseAdapter());

        setBackground(Color.WHITE);

        drawableList = new ArrayList<>();
        tempStartPoint = tempEndPoint = null;
        currentTool = Shape.LINE;
        currentColor = Color.BLACK;
        fillMode = false;

        this.app = app;
    }

    @Override
    public void paintComponent(Graphics g) {
        // �θ� Ŭ���� JPanel�� repaint �ؾ������� ������ �ӽ� �׸��� ���� �ʰ� �������� �ȴ�.
        // �̴� JPanel�� �ƹ� ������Ʈ�� ������ ���� �� ������Ʈ�̱� �����̴�.
        super.paintComponent(g);

        for (Drawable drawable : drawableList) {
            drawDrawable(drawable, g);
        }

        // ����ڰ� �׸��� �׸��� �ִ� ���� ���, �ӽ÷� ����� ��ǥ ���� �̿��� �׸��� �׸���.
        if (tempStartPoint != null && tempEndPoint != null) {
            drawDrawable(new Drawable(tempStartPoint, tempEndPoint, currentTool, currentColor, fillMode), g);
        }
    }

    public void clear() {
        drawableList.clear();
        repaint();
    }

    public void undo() {
        if(drawableList.size() > 0) {
            drawableList.remove(drawableList.size() - 1);
            repaint();
        }
    }

    public void changeTool(Shape newTool) {
        currentTool = newTool;
    }

    public void changeColor(Color newColor) {
        currentColor = newColor;
    }

    public void setFillMode(boolean fillMode) {
        this.fillMode = fillMode;
    }

    private void drawDrawable(Drawable drawable, Graphics g) {
        Color originalColor = g.getColor();

        g.setColor(drawable.color);

        Point sp = drawable.startPoint;
        Point ep = drawable.endPoint;

        // Graphics�� �����ϴ� ���� �׸� ���� �Լ��� ���� �� ��ǥ�� ���� ��ǥ�� ������ ���� ���������,
        // ������ �׸��� �׸� ���� �� �ݴ��� ������ �׸� �� �����Ƿ� ������ �� ������ ����� ��ǥ�� ������־�� �Ѵ�.
        int luX = Math.min(sp.x, ep.x);
        int luY = Math.min(sp.y, ep.y);
        int width = Math.abs(sp.x - ep.x);
        int height = Math.abs(sp.y - ep.y);

        // fillMode�� ���� ������ ���� Graphics�� �ٸ� �Լ��� ȣ���Ѵ�.
        // �������� �̿��ϸ�, ���� �� �ܼ�ȭ��ų �� �ִ�.
        if (drawable.fillMode) {
            switch (drawable.shape) {
                case LINE:
                    g.drawLine(sp.x, sp.y, ep.x, ep.y);
                    break;
                case RECT:
                    g.fillRect(luX, luY, width, height);
                    break;
                case ROUNDED_RECT:
                    g.fillRoundRect(luX, luY, width, height, 20, 20);
                    break;
                case OVAL:
                    g.fillOval(luX, luY, width, height);
                    break;
                case DIAMOND:
                    int[] xs = {luX + width / 2, luX + width, luX + width / 2, luX};
                    int[] ys = {luY, luY + height / 2, luY + height, luY + height / 2};
                    g.fillPolygon(xs, ys, 4);
                    break;
            }
        }
        else {
            switch (drawable.shape) {
                case LINE:
                    g.drawLine(sp.x, sp.y, ep.x, ep.y);
                    break;
                case RECT:
                    g.drawRect(luX, luY, width, height);
                    break;
                case ROUNDED_RECT:
                    g.drawRoundRect(luX, luY, width, height, 20, 20);
                    break;
                case OVAL:
                    g.drawOval(luX, luY, width, height);
                    break;
                case DIAMOND:
                    int[] xs = {luX + width / 2, luX + width, luX + width / 2, luX};
                    int[] ys = {luY, luY + height / 2, luY + height, luY + height / 2};
                    g.drawPolygon(xs, ys, 4);
                    break;
            }
        }

        g.setColor(originalColor);
    }

    public enum Shape {
        LINE,
        RECT,
        ROUNDED_RECT,
        OVAL,
        DIAMOND,
    }

    /**
     * ����ڰ� ���콺�� �̿��� �׸��� �׸� ��, �ӽ÷� �׷����� ���̵������ ó���ϴ� �Լ�.
     * �ӽ� ��ǥ�� �����ϸ鼭 repaint()�� �̿��� Canvas ������Ʈ�� �ٽ� �׸���.
     * ������ ���콺 ��ư�� ������ �� Drawable ��ü�� �߰��Ѵ�.
     */
    private class DrawMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            tempStartPoint = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            tempEndPoint = e.getPoint();
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            drawableList.add(new Drawable(tempStartPoint, e.getPoint(), currentTool, currentColor, fillMode));
            tempStartPoint = tempEndPoint = null;
            repaint();
        }
    }

    /**
     * ĵ���� �� �׷����� ��ü���� ������ ��� �ִ� Ŭ����
     * �� ��쿡�� ������ ����ü�� ����������, �����ϱ⿡ ���󼭴�
     * JPanel�� ��� �޴�, ������ ���� ������Ʈ�� ���� ���� �ִ�.
     */
    private class Drawable {
        public Drawable(Point startPoint, Point endPoint, Shape shape, Color color, boolean fillMode) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
            this.shape = shape;
            this.color = color;
            this.fillMode = fillMode;
        }

        public Point startPoint, endPoint;
        public Shape shape;
        public Color color;
        public boolean fillMode;
    }

    private Point tempStartPoint, tempEndPoint;

    private Shape currentTool;
    private Color currentColor;

    private boolean fillMode;

    private List<Drawable> drawableList;

    private Application app;
}
