package ui;

import forme.Forme;
import forme.FormeFactory;

import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

public class Controller implements KeyListener, MouseListener, MouseMotionListener {

    private final Canevas canevas;

    private int mouseX;
    private int mouseY;
    private Forme hoveredItem;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Controller(Canevas canevas) {
        this.canevas = canevas;

        canevas.getInputMap().put(KeyStroke.getKeyStroke("C"), this);

        canevas.getInputMap().put(KeyStroke.getKeyStroke("L"), this);

        canevas.getInputMap().put(KeyStroke.getKeyStroke("R"), this);

        canevas.getInputMap().put(KeyStroke.getKeyStroke("T"), this);

    }


    @Override
    public void keyTyped(KeyEvent e) {


        if (e.getKeyChar() == 'c') {

            int w = ThreadLocalRandom.current().nextInt(10, 50);

            Forme f = FormeFactory.create(FormeFactory.FORME_CERCLE, mouseX, mouseY, w);

            canevas.addForme( f );

        }

        else if (e.getKeyChar() == 'l') {

            int dx = ThreadLocalRandom.current().nextInt(10, 50);
            int dy = ThreadLocalRandom.current().nextInt(10, 50);

            Forme f = FormeFactory.create(FormeFactory.FORME_LIGNE, mouseX, mouseY, mouseX + dx, mouseY + dy);

            canevas.addForme( f );

        }
        else if (e.getKeyChar() == 'r') {

            int dx = ThreadLocalRandom.current().nextInt(10, 50);
            int dy = ThreadLocalRandom.current().nextInt(10, 50);

            Forme f = FormeFactory.create(FormeFactory.FORME_RECTANGLE, mouseX, mouseY, mouseX + dx, mouseY + dy);

            canevas.addForme( f );

        }

        else if (e.getKeyChar() == 't') {

            int dx = ThreadLocalRandom.current().nextInt(10, 50);
            int dy = ThreadLocalRandom.current().nextInt(10, 50);

            Forme f = FormeFactory.create(FormeFactory.FORME_TRIANGLE, mouseX, mouseY-dy, mouseX-dx, mouseY, mouseX + dx, mouseY);

            canevas.addForme( f );

        }
        
        else if (e.getKeyChar() == 's') {
        	int dx = ThreadLocalRandom.current().nextInt(10, 50);
            int dy = ThreadLocalRandom.current().nextInt(10, 50);
            
            Forme f = FormeFactory.create(FormeFactory.FORME_CONTENEUR, mouseX, mouseX + dx, mouseY, mouseY + dy);
            canevas.addForme(f);
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        mouseX  = e.getX();
        mouseY  = e.getY();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        mouseX  = e.getX();
        mouseY  = e.getY();

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        startX = mouseX;
        startY = mouseY;

        Forme hoveredForme = getHoveredForme();

        if (hoveredForme != null) {
            hoveredItem = hoveredForme;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        endX = mouseX;
        endY = mouseY;

        if (hoveredItem != null) {

            int dx = endX - startX;
            int dy = endY - startY;

            hoveredItem.getInteractor().move(canevas, hoveredItem, (int)(hoveredItem.getBounds().getX() + dx), (int)(hoveredItem.getBounds().getY() + dy));

        }

        hoveredItem = null;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    

    private Forme getHoveredForme() {
        Forme hovered = null;

        for (Forme f : canevas.getFormes()) {

            if (f.getBounds().contains(mouseX, mouseY)) {
                hovered = f;
                break;
            }

        }

        return hovered;
    }



}
