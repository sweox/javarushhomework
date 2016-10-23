package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Created by BELSHINA on 23.10.2016.
 */
public class Snake {
    private ArrayList<SnakeSection> sections = new ArrayList<>();
    private boolean isAlive;
    private SnakeDirection direction;

    public ArrayList<SnakeSection> getSections() {
        return sections;
    }
    public boolean isAlive() {
        return isAlive;
    }
    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
    public SnakeDirection getDirection() {
        return direction;
    }
}
