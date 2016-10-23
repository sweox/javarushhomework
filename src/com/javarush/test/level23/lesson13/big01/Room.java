package com.javarush.test.level23.lesson13.big01;

/**
 * Created by BELSHINA on 23.10.2016.
 */
public class Room {
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
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
    public void setSnake(Snake snake) {
        this.snake = snake;
    }
    public Snake getSnake() {
        return snake;
    }
    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
    public Mouse getMouse() {
        return mouse;
    }

    public static void main(String[] args) {

    }
}
