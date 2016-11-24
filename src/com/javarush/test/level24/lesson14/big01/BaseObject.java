package com.javarush.test.level24.lesson14.big01;

/**
 * Created by BELSHINA on 24.11.2016.
 */
public class BaseObject {
    private double x;
    private double y;
    private double radius;

    public void setX(double x) {
        this.x = x;
    }
    public double getX() {
        return x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getY() {
        return y;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
