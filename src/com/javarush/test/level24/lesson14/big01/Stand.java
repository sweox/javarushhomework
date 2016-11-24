package com.javarush.test.level24.lesson14.big01;

/**
 * Created by BELSHINA on 24.11.2016.
 */
public class Stand extends BaseObject {
    private double speed;
    private double direction;

    public double getSpeed() {
        return speed;
    }
    public double getDirection() {
        return direction;
    }

     public Stand(double x, double y, double radius) {
         super(x, y, radius);
     }
     public Stand(double x, double y) {
         super(x, y, 3);
         this.speed = 1;
         this.direction = 0;
     }

     public void draw(Canvas canvas) {}
     public void move() {
         x = x + direction * speed;
     }

     public void moveLeft() {
         this.direction = -1;
     }
     public void moveRight() {
         this.direction = 1;
     }

}
