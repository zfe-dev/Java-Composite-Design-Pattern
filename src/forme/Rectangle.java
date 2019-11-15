package forme;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends AbstractForme implements Forme {

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public Rectangle(int x1, int y1, int x2, int y2) {

        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

    }

    @Override
    public Rectangle2D getBounds() {
        return new Rectangle2D.Double(x1,y1,x2,y2);
    }

    @Override
    public void moveTo(int x, int y) {

        int dx = x - x1;
        int dy = y - y1;

        this.x1 += dx;
        this.y1 += dy;

        this.x2 += dx;
        this.y2 += dy;

    }
    @Override
    public void render(Graphics g) {

        g.setColor(Color.blue);
        g.fillRect(x1,y1,x2-x1,y2-y1);

    }

}