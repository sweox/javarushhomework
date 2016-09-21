package com.javarush.test.level22.lesson18.big01;

/**
 * Created by BELSHINA on 21.09.2016.
 */
public class Tetris {
    public Field field;
    public Figure figure;
    public static Tetris game;
    public Field getField() {
        return this.field;
    }
    public Figure getFigure() {
        return this.figure;
    }
    public void run() {}
    public void step() {}
    public static void main(String[] args) {
        game = new Tetris();
        game.run();
    }
}
