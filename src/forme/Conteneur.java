package forme;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import ui.FormeInteractor;

public class Conteneur extends AbstractForme implements Forme {
	
	private int x1;
	private int x2;
	private int y1;
	private int y2;

	private Set<Forme> formesSet = new HashSet<>();
	
	public Conteneur(int x1, int x2, int y1, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	@Override
	public void moveTo(int x, int y) {
		this.formesSet.forEach(e -> e.moveTo(x, y));
	}

	@Override
	public Rectangle2D getBounds() {
		List<Integer> x1List = new ArrayList<>();
		List<Integer> x2List = new ArrayList<>();
		List<Integer> y1List = new ArrayList<>();
		List<Integer> y2List = new ArrayList<>();
		this.formesSet.forEach(e -> {
			Rectangle2D rect = e.getBounds();
			x1List.add((int)rect.getMinX());
			x2List.add((int)rect.getMaxX());
			y1List.add((int)rect.getMinY());
			y2List.add((int)rect.getMaxY());
		});
		x1 = x1List.stream().mapToInt(e -> e).min().getAsInt();
		x2 = x2List.stream().mapToInt(e -> e).max().getAsInt();
		y1 = y1List.stream().mapToInt(e -> e).min().getAsInt();
		y2 = y2List.stream().mapToInt(e -> e).max().getAsInt();
		return new Rectangle2D.Double(x1, x2, y1, y2);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.blue);
		this.getBounds();
        g.fillRect(x1,y1,x2-x1,y2-y1);		
	}
	
	public void ajouterForme(Forme form) {
		this.formesSet.add(form);
	}
	
	public void supprimerForme(Forme form) {
		this.formesSet.remove(form);
	}
}
