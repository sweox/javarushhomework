package com.javarush.test.level15.lesson12.bonus01;


public class Plane implements Flyable
{
    int quantity = 0;

    public Plane(int quantity) {
        this.quantity = quantity;
    }
    public void fly() {}
}
