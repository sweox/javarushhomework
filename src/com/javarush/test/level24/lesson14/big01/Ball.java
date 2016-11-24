package com.javarush.test.level24.lesson14.big01;

/**
 * Created by BELSHINA on 24.11.2016.
 */
public class Ball extends BaseObject {
    private double speed;
    private double direction;
    private double dx;
    private double dy;
    private boolean isFrozen;

    public double getSpeed() {
        return speed;
    }
    public double getDirection() {
        return direction;
    }
    public double getDx() {
        return dx;
    }
    public double getDy() {
        return dy;
    }

    public Ball(double x, double y, double radius) {
        super(x, y, radius);
    }
    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        this.isFrozen = true;
    }

    public void draw(Canvas canvas) {
        canvas.setPoint(getX(), getY(), 'O');
    }
    public void move() {
        if(!isFrozen) {
            super.setX(super.getX() + dx);
            super.setY(super.getX() + dy);
        }
    }
    public void start() {
        isFrozen = false;
    }
}
