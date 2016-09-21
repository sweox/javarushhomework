package com.javarush.test.level22.lesson18.big01;

/**
 * Created by BELSHINA on 21.09.2016.
 */
public class Field {
    public int width;
    public int height;
    public int[][] matrix;

    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }
    public int[][] getMatrix() {
        return this.matrix;
    }

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }
}
