package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String a = read.readLine();
        int intA = Integer.parseInt(a);

        String b = read.readLine();
        int intB = Integer.parseInt(b);

        String c = read.readLine();
        int intC = Integer.parseInt(c);

        String d = read.readLine();
        int intD = Integer.parseInt(d);

        System.out.println(max2(max2(intA, intB), max2(intC, intD)));



    }
    //    ==========================
    public static int max2(int i, int j)
    {
        if (i > j)
            return i;
        else
            return j;
    }
    //=================================
   /** public static void max2(int a1, int b, int c, int d)
    {
        return max2(max2(a, b), max2(c, d));
    }*/
}
