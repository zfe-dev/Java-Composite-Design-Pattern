package forme;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import ui.FormeInteractor;

public class PoisDecorator extends DecorateurForme {
	
	Rectangle2D mesures; 
	
	public PoisDecorator (Forme form) {
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
		g.drawOval((int)mesures.getMinX(), (int)mesures.getMinY(), (int)(mesures.getMaxX() - mesures.getMinX()) , (int)(mesures.getMaxY() - mesures.getMinY()));
	}

}
