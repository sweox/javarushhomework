package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка  с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++)
        {
            String s = reader.readLine();
            int x = Integer.parseInt(s);
            list.add(x);
        }
//========================================
        ArrayList<Integer> even3 = new ArrayList<Integer>();
        ArrayList<Integer> even2 = new ArrayList<Integer>();
        ArrayList<Integer> other = new ArrayList<Integer>();

        for (int i = 0; i < list.size(); i++)
        {
            int tmp = list.get(i);
            if (tmp % 3 == 0 && tmp % 2 == 0)
            {
                even3.add(tmp);
                even2.add(tmp);
            }
            else if (tmp % 3 == 0)
                even3.add(tmp);
            else if (tmp % 2 == 0)
                even2.add(tmp);
            else other.add(tmp);
        }
//=====================================
        printList(even3);
        printList(even2);
        printList(other);
    }
//======================================================
    public static void printList(List<Integer> list) {
        //add your code here
        for (Integer x : list)
            System.out.println(x);
    }
}
