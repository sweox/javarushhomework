package com.javarush.test.level12.lesson09.task02;

/* Интерфейсы Fly, Run, Swim
Напиши public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавить в каждый интерфейс по одному методу.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

//add interfaces here - добавь интерфейсы тут
    public interface Fly {
        void fly();
    }
    public interface Run {
        void run();
    }
    public interface Swim {
        void swim();
    }

/**
interface Fly {
    int takeOff (int height); //взлёт - высота
}

    interface Run {
        int speedMove (int speed); //скорость движения - скорость
    }

    interface Swim {
        int depthWater (int depth); //глубина воды - глубина
    }
*/

}
