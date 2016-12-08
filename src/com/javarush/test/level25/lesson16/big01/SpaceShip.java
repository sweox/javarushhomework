package com.javarush.test.level25.lesson16.big01;

/**
 * Created by BELSHINA on 08.12.2016.
 */
public class SpaceShip extends BaseObject {
    public SpaceShip(int x, int y) {
        super(x, y, 3);
    }

    private double dx = 0;
    public void moveLeft() {
        dx = -1;
    }
    public void moveRight() {
        dx = 1;
    }
    public void move() {
        x += dx;
        checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight() + 1);
    }
    public void draw() {}
    public void fire() {
        Space.game.getRockets().add(new Rocket(x - 2, y));
        Space.game.getRockets().add(new Rocket(x + 2, y));
    }
}
