package com.javarush.test.level25.lesson16.big01;

/**
 * Created by BELSHINA on 08.12.2016.
 */
public class Canvas {
    private int width;
    private int height;
    char[][] matrix;

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public char[][] getMatrix() {
        return matrix;
    }

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height][width];
    }

    public void setPoint(double x, double y, char c) {
        matrix[(int)Math.round(y)][(int)Math.round(x)] = c;
    }
    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }
    public void clear() {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ' ';
            }
        }
    }
    public void print() {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
