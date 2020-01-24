package com.Arkanoid;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Mahou {

    private static int Y = 330;
    private static int WITH = 60;
    private static int HEIGHT = 10;
    int x = 0;
    int xa = 0;
    private Main game;

    public Mahou(Main game) {
        this.game = game;
    }

    public void paint(Graphics2D g, int x, int Y, int WITH, int HEIGHT) {
        this.x = x;
        this.Y = Y;
        this.WITH = WITH;
        this.HEIGHT = HEIGHT;
        g.fillRect(x, Y, WITH, HEIGHT);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WITH, HEIGHT);
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

}
