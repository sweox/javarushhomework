package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Belshina on 06.10.15.
 */
public class Earth implements Planet
{
    private static Earth instance = null;
    private Earth() {}
    public static Earth getInstance() {
        if (instance == null)
            instance = new Earth();
        return instance;
    }
}
