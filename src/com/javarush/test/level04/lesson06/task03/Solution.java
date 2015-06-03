package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String a = reader.readLine();
        String b = reader.readLine();
        String c = reader.readLine();

        int intA = Integer.parseInt(a);
        int intB = Integer.parseInt(b);
        int intC = Integer.parseInt(c);
        //-----------------------
        int max = max3(intA, intB, intC);
        int min = min3(intA, intB, intC);
        int medium = medium3(intA, intB, intC, min, max);
        //---------------------
        System.out.println(max + " " + medium + " " + min);
    }
//====================
    // поиск минимального числа из 3-х
    public static int min3(int i, int j, int k)
    {
        if (i < j && i < k)
            return i;
        else
            if (j < i && j < k)
                return j;
        else
                return k;
    }
    //=============================
    //поиск максимального числа из 3-х
    public static int max3(int i, int j, int k)
    {
        if (i > j && i > k)
            return i;
        else
            if (j > i && j > k)
                return j;
        else
                return k;
    }
    //==================================
    //поиск среднего числа
    public static int medium3(int i, int j, int k, int min3, int max3)
    {
        if (i > min3 && i <max3)
            return i;
        else
            if (j > min3 && j < max3)
                return j;
        else
                return k;
    }
}
