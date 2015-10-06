package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Belshina on 06.10.15.
 */
public class Singleton
{
    /*private static Singleton instance = new Singleton();
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }*/
//=============================================
    private static Singleton instance = null;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
//==================================================
    /*private Singleton() {}
    private static class SingletonHolder {
        private final static Singleton instance = new Singleton();
    }
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }*/
}
