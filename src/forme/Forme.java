package forme;

import ui.FormeInteractor;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public interface Forme {

    void moveTo(int x, int y);

	Rectangle2D getBounds();

	void render(Graphics g);

	FormeInteractor getInteractor();



}