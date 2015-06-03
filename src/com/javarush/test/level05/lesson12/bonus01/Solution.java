package com.javarush.test.level05.lesson12.bonus01;

import java.io.*;

/* Нужно исправить программу, чтобы компилировалась и работала
Задача: Программа вводит два числа с клавиатуры и выводит их сумму на экран.
*/

/**public class Solution
{
   public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = reader.readLine();
        int b = reader.read();

        int sum = a + b;
        System.out.println("Sum = " + sum);
    }
}   */

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        int intA = Integer.parseInt(a);
        int intB = Integer.parseInt(b);

        int sum = intA + intB;
        System.out.println("Sum = " + sum);
    }
}