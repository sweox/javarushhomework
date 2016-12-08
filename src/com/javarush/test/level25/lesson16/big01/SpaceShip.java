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
}
