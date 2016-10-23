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

    public void run() {}
    public void sleep() {}
    public void print() {}
    public void createMouse() {
        int x = (int) (Math.random() * width);
        int y = (int)(Math.random() * height);
        mouse = new Mouse(x, y);
    }
    public void eatMouse() {
        createMouse();
    }

    public static Room game;
    public static void main(String[] args) {
        Snake snake = new Snake(5, 5);
        game = new Room(10, 10, snake);
        game.getSnake().setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
    }

}
