package forme;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Triangle extends AbstractForme implements Forme {

    private int x1;
    private int x2;
    private int x3;
    private int y1;
    private int y2;
    private int y3;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;


    }

    @Override
    public Rectangle2D getBounds() {
        Polygon polygon = new Polygon(new int[] {x1,x2,x3}, new int[] {y1,y2,y3}, 3);
        return polygon.getBounds2D();
    }

    @Override
    public void moveTo(int x, int y) {
        int dx = x - x1;
        int dy = y - y1;

        this.x1 += dx;
        this.y1 += dy;
        this.x2 += dx;
        this.y2 += dy;
        this.x3 += dx;
        this.y3 += dy;


    }
    @Override
    public void render(Graphics g) {

        g.setColor(Color.orange);

        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x3, y3, x1, y1);

    }
    

}