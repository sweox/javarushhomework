package com.javarush.test.level12.lesson06.task05;

/* Классы Cat и Dog от Pet
Унаследуй классы Cat и Dog от Pet.
Реализуй недостающие методы. Классы Cat и Dog не должны быть абстрактными.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static abstract class Pet
    {
        public abstract String getName();
        public abstract Pet getChild();
    }

    public static class Cat extends Pet
    {
        private String name = null;
        private Pet child = new Cat();
        public String getName()
        {
            return name;
        }
        public Pet getChild()
        {
            return child;
        }
    }

    public static class Dog extends Pet
    {
        private String name = null;
        private Pet child = new Dog();
        public String getName()
        {
            return name;
        }
        public Pet getChild()
        {
            return child;
        }
    }

}

/**
public class Solution
{
    public static void main(String[] args)
    {

    }

    public static abstract class Pet
    {
        public abstract String getName();
        public abstract Pet getChild();
    }

    public static class Cat
    {
    }

    public static class Dog
    {

    }

}
*/