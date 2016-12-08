package com.javarush.test.level25.lesson16.big01;

/**
 * Created by BELSHINA on 08.12.2016.
 */
public class Rocket extends BaseObject {
    public Rocket(double x, double y) {
        super(x, y, 1);
    }
    public void move() {
        --y;
    }
    public void draw(Canvas canvas) {
        canvas.setPoint(x,y,'R');
    }
}
