package com.javarush.test.level09.lesson11.home01;

import java.io.StringWriter;
import java.io.PrintWriter;

/* Деление на ноль
Создай метод public static void divisionByZero, в котором подели любое число на ноль и
выведи на экран результат деления.
Оберни вызов метода divisionByZero в try..catch. Выведи стек-трейс исключения используя
метод exception.printStackTrace()
*/

public class Solution {

    public static void main(String[] args)
    {
        try
        {
            divisionByZero();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //===========================
            //StringWriter stringWriter = new StringWriter();
            //PrintWriter printWriter = new PrintWriter(stringWriter);
            //e.printStackTrace(printWriter);
            //System.out.println(stringWriter.toString());
            //===========================
            //for (StackTraceElement i:e.getStackTrace())
            //    System.out.println(i);
        }
    }

    public static void divisionByZero() throws Exception
    {
        int i = 5 / 0;
        System.out.println(i);
    }
}
