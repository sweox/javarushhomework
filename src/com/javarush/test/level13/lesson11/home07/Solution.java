package com.javarush.test.level13.lesson11.home07;

/* Интерфейс SimpleObject
1. Создай класс StringObject.
2. В классе StringObject реализуй интерфейс SimpleObject с параметром типа String.
3. Программа должна компилироваться.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       SimpleObject<String> stringObject = new StringObject<Object>();
    }

    interface SimpleObject<T>
    {
        SimpleObject<T> getInstance();
    }

    public static class StringObject<Object> implements SimpleObject<String>
    {
        public SimpleObject<String> getInstance()
        {
            return StringObject.this;
            //return new StringObject<Object>();

        }
    }

}
/*

Ну интерфейс SimpleObject реализует работу с объектами типа T. Класс StringObject имплементит
данный интерфейс, а значит он должен тоже работать с какими то объектами.
А строчка

SimpleObject<String> stringObject = new StringObject<Object>();

показывает что именно должен возвращать метод getInstance(), а так же он показывает
конструктор какого класса вызывается.=)
 */
/*
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        SimpleObject<String> stringObject = new StringObject<Object>();
    }

    interface SimpleObject<T>
    {
        SimpleObject<T> getInstance();
    }
}
*/