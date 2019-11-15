package ui;

import forme.Forme;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Canevas extends JPanel {

    private List<Forme> formes = new ArrayList<Forme>();

    private final Controller controller;

    public Canevas() {

        super ( new BorderLayout() );

        this.controller = new Controller(this);

        addMouseListener(controller);
        addKeyListener(controller);
        addMouseMotionListener(controller);


    }

	public void addForme(Forme forme) {
		formes.add( forme );

        repaint();
	}

	public List<Forme> getFormes() {
		return formes;
	}


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Forme f : getFormes()) {

            f.render( g );
        }

    }




}