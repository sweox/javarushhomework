package com.javarush.test.level24.lesson14.big01;

/**
 * Created by BELSHINA on 24.11.2016.
 */
public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
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
    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
    public char[][] getMatrix() {
        return matrix;
    }
}
