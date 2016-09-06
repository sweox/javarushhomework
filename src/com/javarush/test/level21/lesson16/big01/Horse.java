package com.javarush.test.level21.lesson16.big01;


public class Horse {
    String name;
    double speed;
    double distance;

    public Horse( String name, double speed, double distance ) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public double getSpeed() {
        return this.speed;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public double getDistance() {
        return this.distance;
    }
}
