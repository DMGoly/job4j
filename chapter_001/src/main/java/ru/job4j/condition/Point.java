package ru.job4j.condition;

/**
 * Package for calculate task.
 *
 * @author Dmitry Golyshkin(dmgoly@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Point {
    public double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(
                Math.pow(x2 - x1, 2) +
                Math.pow((y2 - y1),2)
        );
    }
}