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
        matrix = new char[height][width];
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

    public void setPoint(double x, double y, char c) {
        if(!(x<0) && !(y<0) && !(y>matrix.length) && !(x>matrix[0].length)) {
            int xInt = (int) Math.round(x);
            int yInt = (int) Math.round(y);
            matrix[yInt][xInt] = c;
        }

    }
    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }
}
