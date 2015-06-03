package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //System.out.println("Введите первое число ");
        String a = reader.readLine();
        int intA = Integer.parseInt(a);
        //System.out.println("Введите второе число ");
        String b = reader.readLine();
        int intB = Integer.parseInt(b);

        if (intA < intB)
            System.out.println(a);
            //System.out.println("минимум =  " + a);
            //System.out.println("введите " + a + " и " + b + ", " + "минимум =  " + a);
        else
            System.out.println(b);
            //System.out.println("минимум =  " + b);
            //System.out.println("введите " + a + " и " + b + ", " + "минимум =  " + b);


        //Напишите тут ваш код

        /* данные для тестирования:
        введите 1 и 2, минимум =  1
        введите 2 и 1, минимум =  1
        введите 1 и 1, минимум =  1
        введите -1 и -2, минимум =  -2
         */
    }
}