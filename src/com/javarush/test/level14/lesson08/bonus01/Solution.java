package com.javarush.test.level14.lesson08.bonus01;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        //-----------2-------ArrayIndexOutOfBoundsException
        try
        {
            int[] a = {1, 4, 6};
            for (int i = 0; a.length <6;  i++)
            {
                System.out.println(a[i - 10]);
            }
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //-----------3-------ClassCastException
        try
        {
            Object g = new Float(5.0);
            System.out.println((String) g);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //----------4----IndexOutOfBoundsException
        try
        {
            ArrayList<List> list = new ArrayList<List>();
            list.get(55);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //--------5-----NullPointerException
        try
        {
            String test = null;
            if (test.equals("j")) {}

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //--------6------FileNotFoundException
        try
        {
            FileInputStream re = new FileInputStream("C:\\t.t");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //---------7-----NumberFormatException
        try
        {
            String myVar = "1255763710960";
            int myTempVar;
            myTempVar = Integer.valueOf(myVar);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //-------8-----NegativeArraySizeException
        try
        {
            int i = -1;
            int[] g = new int[i];
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        //------9-----IllegalThreadStateException
        try
        {
            Thread d1 = new Thread();
            d1.start();
            d1.start();
        }
        catch (IllegalThreadStateException e) {
            exceptions.add(e);
        }
        //-------10----
        try
        {
            Object x[]=new String[3];
            x[0]=new Integer(10);
        }
        catch (ArrayStoreException e) {
            exceptions.add(e);
        }
    }

}

/*
public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here

    }
}
*/