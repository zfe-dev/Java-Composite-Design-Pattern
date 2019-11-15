package ui;

import forme.Forme;

public class FormeInteractor {

    private static FormeInteractor instance = new FormeInteractor();

    private FormeInteractor() {

    }

    public static FormeInteractor getInstance() {
        return instance;
    }

    public void move(Canevas canevas, Forme forme, int x, int y) {

        forme.moveTo(x, y);

        canevas.repaint();

    }

}