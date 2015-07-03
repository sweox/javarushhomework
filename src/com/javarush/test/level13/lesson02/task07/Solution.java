package com.javarush.test.level13.lesson02.task07;

/* Параметризованый интерфейс
В классе StringObject реализуй интерфейс SimpleObject с параметром типа String.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //System.out.println(new StringObject().getInstance());
    }

    interface SimpleObject<T>
    {
        SimpleObject<T> getInstance();
    }

    public static class StringObject implements SimpleObject//<String>//допишите здесь ваш код
    {
        private SimpleObject<String> t;
        public SimpleObject<String> getInstance()
        {
            return this;
        }
    }
}

/**
public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }

    interface SimpleObject<T>
    {
        SimpleObject<T> getInstance();
    }

    class StringObject //допишите здесь ваш код
    {
    }
}
*/