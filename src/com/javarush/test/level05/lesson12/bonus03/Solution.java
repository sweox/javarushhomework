package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

/**public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = ;

        //напишите здесь ваш код

        System.out.println(maximum);
    }
}   */

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum = 0;

        //напишите здесь ваш код
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++)
        {
            int number = Integer.parseInt(reader.readLine());
            if (i == 0)
                number = maximum;
            else
                if (number > maximum)
            {
                maximum = number;
            }
        }

        System.out.println(maximum);
    }
}
