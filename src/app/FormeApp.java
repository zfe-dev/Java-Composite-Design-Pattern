package app;

import ui.Canevas;
import ui.Fenetre;

import javax.swing.*;
import java.awt.*;

public class FormeApp {

	public static void main(String[] args) {

		new FormeApp().run();

	}

	public void run() {

        Fenetre fenetre = new Fenetre( new Canevas() );
        fenetre.show();

	}

}