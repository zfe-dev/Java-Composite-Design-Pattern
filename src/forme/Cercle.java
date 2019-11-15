package forme;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Cercle extends AbstractForme implements Forme {

    private int x;
    private int y;
    private final int width;
    private Ellipse2D.Double ellipse;


    private void setDimensions(int x, int y, int width) {
        ellipse = new Ellipse2D.Double(x, y, width, width);
    }

    public Cercle(int x, int y, int width) {

        this.x = x;
        this.y = y;
        this.width = width;

        setDimensions(x, y, width);

    }

    @Override
    public void moveTo(int x, int y) {

        this.x = x;
        this.y = y;
        setDimensions(x, y, width);
    }

    @Override
    public Rectangle2D getBounds() {
        return ellipse.getBounds2D();
    }

    @Override
    public void render(Graphics g) {

       Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(new Color(127, 0, 255));

        g2D.fill( ellipse );

    }


}