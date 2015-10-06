package com.javarush.test.level15.lesson12.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Закрепляем Singleton pattern
1. Найти в гугле пример для - Singleton pattern Lazy initialization.
2. По образу и подобию в отдельных файлах создать три синглтон класса Sun, Moon, Earth.
3. Реализовать интерфейс Planet для классов Sun, Moon, Earth.
4. В статическом блоке класса Solution вызвать метод readKeyFromConsoleAndInitPlanet.
5. Реализовать функционал метода readKeyFromConsoleAndInitPlanet:
5.1. С консоли считать один параметр типа String.
5.2. Если параметр равен одной из констант интерфейса Planet, то создать соответствующий объект
и присвоить его Planet thePlanet, иначе обнулить Planet thePlanet.
5.3. Сравнивать введенный параметр можно только с константами из Planet, нельзя создавать свои
строки.
*/

/*Переменная типа интерфейс может содержать либо нулевую ссылку, либо ссылку на объект
любого класса, реализующий данный интерфейс.*/

public class Solution {
    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        try
        {
            readKeyFromConsoleAndInitPlanet();
        }
        catch (Exception e)
        {
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws Exception{
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String r = null;
        if ((r = reader.readLine()).equals(Sun.SUN))
            thePlanet = Sun.getInstance();
        else if (r.equals(Moon.MOON))
            thePlanet = Moon.getInstance();
        else if (r.equals(Earth.EARTH))
            thePlanet = Earth.getInstance();
        else
            thePlanet = null;
    }
}


/*
public class Solution {
    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        thePlanet = Sun.getInstance();
    }
}
*/
