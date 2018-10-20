package game.model;

import java.awt.*;

/**
 * The neighbour model. Describes the neighbours parameters.
 * @author Dmitry Kryukov, Ksenia Popova
 */
public class Neighbour {
    private Country one;
    private Country two;

    /**
     * Counstructor of the class
     * @param one start of connection
     * @param two end of connection
     */
    public Neighbour(Country one, Country two) {
        this.one = one;
        this.two = two;
        one.getNeighbours().add(two);
        two.getNeighbours().add(one);
    }

    /**
     * Getter for start point of the connection
     * @return one
     */
    public Country getOne() {
        return one;
    }

    /**
     * Getter for end point of the connection
     * @return two
     */
    public Country getTwo() {
        return two;
    }

    /**
     * Drawer. Displays the connection as a line
     * @param g
     */
    public void draw (Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);

        g2d.drawLine(one.getX(), one.getY(), two.getX(), two.getY());
    }
}