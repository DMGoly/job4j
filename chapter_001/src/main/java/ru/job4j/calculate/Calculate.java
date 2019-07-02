package ru.job4j.calculate;

/**
 * Package for calculate task.
 *
 * @author Dmitry Golyshkin(dmgoly@gmail.com)
 * @version $Id$
 * @since 0.1
 **/

public class Calculate {
    public static void main(String[] args) {
        System.out.println("Hello, Job4j.");
    }
    /**
     * Method echo.
     * @param name Your name.
     * @return Echo plus your name.
     */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
}
