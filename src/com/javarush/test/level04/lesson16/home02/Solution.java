package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String a = read.readLine();
        String b = read.readLine();
        String c = read.readLine();

        int intA = Integer.parseInt(a);
        int intB = Integer.parseInt(b);
        int intC = Integer.parseInt(c);

        System.out.println(medium(intA, intB, intC));

    }

    public static int medium(int i, int j, int k)
    {
        if (i > j & i < k)
            return i;
        if (i > k & i < j)
            return i;
        if (j > i & j < k)
            return j;
        if (j > k & j < i)
            return j;
        //if (k > i & k < j)
        //    return k;
        //if (k > j & k < i)
        //    return k;
        else
             return k;
    }
}
