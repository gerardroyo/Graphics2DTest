package com.Arkanoid;

import java.awt.*;

public class Ball {
    private static final int DIAMETER = 30;

    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Main game;

    public Ball(Main game) {
        this.game = game;
    }

    void move() {
        boolean changeDirection = true;
        if (x + xa < 0)
            xa = game.speed;
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;
        else if (y + ya < 0)
            ya = game.speed;
        else if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        else if (collision()){
            ya = -game.speed;
            y = game.racquet.getTopY() - DIAMETER;
            //game.speed++;
        }
        else if(collisionMahou()){
            System.out.println(this.y + this.DIAMETER + " <= " + game.mahou.getY());
            System.out.println(this.y + " <= " + game.mahou.getUnderY());
            if(this.y + this.DIAMETER - 1 <= game.mahou.getY()){
                ya = -1;
            }
            else if(this.y + 1 >= game.mahou.getUnderY()){
                ya = 1;
            }
            else if(this.x + this.DIAMETER - 1 <= game.mahou.getX()){
                xa = -1;
            }
            else if(this.x + 1 >= game.mahou.getRightX()){
                xa = 1;
            }
        }

        //if (changeDirection)
            //Sound.BALL.play();
        x = x + xa;
        y = y + ya;
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }
    private boolean collisionMahou() {
        return game.mahou.getBoundsMahou().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }

}
