package com.javarush.test.level13.lesson11.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        ArrayList<Integer> array = new ArrayList<Integer>();

        while (fileReader.ready())
        {
            int x = Integer.parseInt(fileReader.readLine());
            if (x % 2 == 0)
            {
                array.add(x);
            }

        }

        //=============================
        sort(array);
        //Collections.sort(array);
        for (Integer x:array)
        {
            System.out.println(x);
        }
        fileReader.close();
    }
    public static void sort(ArrayList<Integer> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            for (int j = 0; j < list.size(); j++)
            {
                if (list.get(j) > list.get(i))
                {
                    int tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
    }
}

/*
public class Solution
{
    public static void main(String[] args)
    {
        // напишите тут ваш код
    }
}
*/