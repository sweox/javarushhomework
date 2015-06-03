package com.javarush.test.level04.lesson13.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String m = read.readLine();
        String n = read.readLine();
        int intM = Integer.parseInt(m);
        int intN = Integer.parseInt(n);

        for (int j = 0; j < intM; j++)
        {
            for (int k = 0; k < intN; k++)
            {
                System.out.print("8");
            }
            System.out.println();
        }

    }
}
