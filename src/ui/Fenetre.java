package ui;

import javax.swing.*;

public class Fenetre {

    private final JFrame frame;

    public Fenetre(Canevas canevas) {

        frame = new JFrame("Forme App");

        frame.add( canevas );

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(700,500);

    }

    public void show() {

        frame.setVisible(true);

    }


}