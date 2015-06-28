package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/
/**
//=======================1 -е решение============
public class Solution
{
    public static void main(String[] args)
    {
        int a = 3;
        Integer b = (Integer) a;
        System.out.println(print(a));
        System.out.println(print(b));
    }

    //Напишите тут ваши методы

        public static int print(int a)
        {
            return a;
        }

        public static Integer print(Integer a)
        {
            return a;
        }
}
*/


 //===============2-е решение========
public class Solution
{
    public static void main(String[] args)
    {
        int a = 3;
        print(a);
        print((Integer)a);
    }

    //Напишите тут ваши методы

    public static void print(int a)
    {
    }

    public static void print(Integer a)
    {
    }
}

/**
public class Solution
{
    public static void main(String[] args)
    {

    }

    //Напишите тут ваши методы
}
*/