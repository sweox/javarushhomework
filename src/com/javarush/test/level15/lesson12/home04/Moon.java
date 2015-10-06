package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Belshina on 06.10.15.
 */
public class Moon implements Planet
{
    private static Moon instance = null;
    private Moon() {}
    public static Moon getInstance() {
        if (instance == null)
            instance = new Moon();
        return instance;
    }
}
