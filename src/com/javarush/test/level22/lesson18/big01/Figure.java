package com.javarush.test.level22.lesson18.big01;

/**
 * Created by BELSHINA on 21.09.2016.
 */
public class Figure {
    public int x;
    public int y;
    public int[][] matrix;

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int[][] getMatrix() {
        return this.matrix;
    }

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public void left() {}
    public void right() {}
    public void down() {}
    public void up() {}
    public void downMaximum() {}
    public void rotate() {}
    public boolean isCurrentPositionAvailable() {return true;}
    public void landed() {}
}
