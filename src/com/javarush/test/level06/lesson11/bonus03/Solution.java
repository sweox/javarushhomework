package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Напишите тут ваш код
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());
        int min1, min2, min3, min4, min5;

        if (a < b && a < c && a < d && a < e)
        {
            min1 = a;
            a = e;
        }
        else if (b < a && b < c && b < d && b < e)
        {
            min1 = b;
            b = e;
        }
        else if (c < a && c < b && c < d && c < e)
        {
            min1 = c;
            c = e;
        }
        else if (d < a && d < b && d < c && d < e)
        {
            min1 = d;
            d = e;
        }
        else
        {
            min1 = e;
        }
        //============================================
        if (a < b && a < c && a < d)
        {
            min2 = a;
            a = d;
        }
        else if (b < a && b < c && b < d)
        {
            min2 = b;
            b = d;
        }
        else if (c < a && c < b && c < d)
        {
            min2 = c;
            c = d;
        }
        else
        {
            min2 = d;
        }
        //============================================
        if (a < b && a < c)
        {
            min3 = a;
            a = c;
        }
        else if (b < a && b < c)
        {
            min3 = b;
            b = c;
        }
        else
            min3 = c;
        //========================================
        if (a < b)
        {
            min4 = a;
            min5 = b;
        }
        else
        {
            min4 = b;
            min5 = a;
        }
        //=============================
        System.out.println(min1);
        System.out.println(min2);
        System.out.println(min3);
        System.out.println(min4);
        System.out.println(min5);
    }
}

  /**      int min5 = min(min(min(a, b), min(c, d)),e);
        int min4 = min(min(a, b), min(c, d));
        int min3 = min(min(a, b), c);
        int min2 = min(a, b);
        int max2 = max(a, b);

        System.out.println(min5);
        System.out.println(min4);
        System.out.println(min3);
        System.out.println(min2);
        System.out.println(max2);


    public static int min(int i, int j)
        {
            return (i < j)?i:j;
        }
    public static int max(int i, int j)
        {
             return (i > j) ? i : j;
        }



/**Я решил громоздко и вышел глянуть нет ли попроще: оказалось в рамках пройденного материала я в целом наверное прав, так что и вам подскажу «громоздкое решение в рамках изученного курса»:
 1. Находите минимум из 5 цифр.
 2. Устанавливаете какой введенной цифре он равен (первой, второй...) и присваиваете ей значение пятой (например) цифры.
 3. Находите минимум из 4 цифр (первых четырех если в п. 2 вы присвоили значение пятой).
 4. Устанавливаете какой введенной цифре он равен и присваиваете ей значение четвертой (например).
 5. Находите минимум из 3 цифр…
 Все громоздко, но на самом деле не так чтоб уж слишком.
 */
