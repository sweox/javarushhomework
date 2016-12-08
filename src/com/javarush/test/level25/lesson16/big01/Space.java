package com.javarush.test.level25.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by BELSHINA on 08.12.2016.
 */
public class Space {
    public static Space game;

    private int width;
    private int height;
    private SpaceShip ship;
    ArrayList<Ufo> ufos = new ArrayList<>();
    ArrayList<Rocket> rockets = new ArrayList<>();
    ArrayList<Bomb> bombs = new ArrayList<>();

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public SpaceShip getShip() {
        return ship;
    }
    public ArrayList<Ufo> getUfos() {
        return ufos;
    }
    public ArrayList<Rocket> getRockets() {
        return rockets;
    }
    public ArrayList<Bomb> getBombs() {
        return bombs;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    public void run() {}
    public void draw() {}
    public void sleep(int ms) {}

    public static void main(String[] args) {

    }
}
