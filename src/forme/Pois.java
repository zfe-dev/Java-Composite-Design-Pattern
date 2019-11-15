package forme;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import ui.FormeInteractor;

public class Pois extends DecorateurForme {
	
	Rectangle2D mesures; 
	
	public Pois (Forme form) {
		this.form = form;
		mesures = this.form.getBounds();
	}

	@Override
	public void moveTo(int x, int y) {
		this.form.moveTo(x, y);
	}

	@Override
	public Rectangle2D getBounds() {
		return mesures;
	}

	@Override
	public void render(Graphics g) {
		this.form.render(g);
		g.setColor(new Color(255, 0, 0, 50));
		g.drawOval((int)((mesures.getMaxX() + mesures.getMinX()) / 2), (int)((mesures.getMaxY() + mesures.getMinY()) / 2), (int)((mesures.getMaxX() + mesures.getMinX()) / 6), (int)((mesures.getMaxX() + mesures.getMinX()) / 6));
	}

}
