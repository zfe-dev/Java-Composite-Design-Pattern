package forme;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class LabelDecorator extends DecorateurForme{

Rectangle2D mesures; 
	
	public LabelDecorator (Forme form) {
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
		g.setColor(Color.BLACK);
		g.drawString("Label decorator", (int)mesures.getMinX(), (int)mesures.getMinY());
	}


}
