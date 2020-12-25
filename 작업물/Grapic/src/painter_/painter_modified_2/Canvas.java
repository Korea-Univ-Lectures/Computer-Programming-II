package painter_modified_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 실제로 그림이 그려지는 빈 공간을 나타내는 클래스.
 * 빈 공간에 대한 입력과 그림을 그리는 처리를 실제로 수행한다.
 */
public class Canvas extends JPanel {
    public Canvas(Application app) {
        super();

        // 마우스 조작에 해당하는 리스너를 등록한다. 이 부분이 빈 공간에 입력이 주어졌을 각각의
        // Drawable 개체를 추가하는 역할을 담당한다.
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
        // 부모 클래스 JPanel을 repaint 해야지만이 이전의 임시 그림이 남지 않고 지워지게 된다.
        // 이는 JPanel이 아무 컴포넌트를 가지지 않은 빈 컴포넌트이기 때문이다.
        super.paintComponent(g);

        for (Drawable drawable : drawableList) {
            drawDrawable(drawable, g);
        }

        // 사용자가 그림을 그리고 있는 중인 경우, 임시로 저장된 좌표 값을 이용해 그림을 그린다.
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

        // Graphics가 제공하는 도형 그림 관련 함수는 왼쪽 위 좌표를 시작 좌표로 제공할 것을 기대하지만,
        // 실제로 그림을 그릴 때는 그 반대의 순서로 그릴 수 있으므로 실제로 더 원점에 가까운 좌표를 계산해주어야 한다.
        int luX = Math.min(sp.x, ep.x);
        int luY = Math.min(sp.y, ep.y);
        int width = Math.abs(sp.x - ep.x);
        int height = Math.abs(sp.y - ep.y);

        // fillMode와 도구 종류에 따라 Graphics의 다른 함수를 호출한다.
        // 다형성을 이용하면, 조금 더 단순화시킬 수 있다.
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
                {
                    int[] xs = {luX + width / 2, luX + width, luX + width / 2, luX};
                    int[] ys = {luY, luY + height / 2, luY + height, luY + height / 2};
                    g.fillPolygon(xs, ys, 4);
                }
                    break;
                case TRIANGLE:
                {
                    int[] xs = {luX, luX + width, luX};
                    int[] ys = {luY, luY, luY + height};
                    g.fillPolygon(xs, ys, 3);
                }
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
                {
                    int[] xs = {luX + width / 2, luX + width, luX + width / 2, luX};
                    int[] ys = {luY, luY + height / 2, luY + height, luY + height / 2};
                    g.drawPolygon(xs, ys, 4);
                }
                    break;
                case TRIANGLE:
                {
                    int[] xs = {luX, luX + width, luX};
                    int[] ys = {luY, luY, luY + height};
                    g.drawPolygon(xs, ys, 3);
                }
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
        TRIANGLE
    }

    /**
     * 사용자가 마우스를 이용해 그림을 그릴 때, 임시로 그려지는 가이드라인을 처리하는 함수.
     * 임시 좌표를 갱신하면서 repaint()를 이용해 Canvas 컴포넌트를 다시 그린다.
     * 실제로 마우스 버튼을 떼었을 때 Drawable 객체를 추가한다.
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
     * 캔버스 상에 그려지는 물체들의 정보를 담고 있는 클래스
     * 이 경우에는 일종의 구조체로 구현했으나, 구현하기에 따라서는
     * JPanel을 상속 받는, 각각의 도형 컴포넌트를 만들 수도 있다.
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
