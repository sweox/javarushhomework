package com.javarush.test.level24.lesson14.big01;

import java.util.ArrayList;

/**
 * Created by BELSHINA on 24.11.2016.
 */
public class Arcanoid {
    private int width;
    private int height;

    private Ball ball;
    private Stand stand;
    private ArrayList<Brick> bricks;

    public Arcanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth() {
        return width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
    public Ball getBall() {
        return ball;
    }
    public void setStand(Stand stand) {
        this.stand = stand;
    }
    public Stand getStand() {
        return stand;
    }
    public void setBricks(ArrayList<Brick> bricks) {
        this.bricks = bricks;
    }
    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public static void main(String[] args) {

    }
}
