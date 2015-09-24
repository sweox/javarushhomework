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
        //открываем поток для чтения имени файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close(); //закрываем поток

        //Создаем лист, в котором будем хранить данные
        ArrayList<Integer> list = new ArrayList<Integer>();

        //Открываем поток чтения из файла
        BufferedReader inputStream = new BufferedReader(new FileReader(fileName));

        while (inputStream.ready()) //пока данные читаются
        {
            int i = Integer.parseInt(inputStream.readLine());
            if (i%2==0) list.add(i);
        }

        Collections.sort(list); //сортируем

        for (int i : list) System.out.println(i);

    }
}

/*
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(s));

        ArrayList<Integer> list = new ArrayList<Integer>();

        String num = br.readLine();

        while ((num = reader.readLine()) != null) {
            int number = Integer.parseInt(num);
            if ((number%2==0)) {
                list.add(number);
            }
        }

        Collections.sort(list);
        for (int x: list) {
            System.out.println(x);
        }
    }
}
*/
//=============мой вариант
/*
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
        //sort(array);
        Collections.sort(array);
        for (Integer x:array)
        {
            System.out.println(x);
        }
        fileReader.close();
        reader.close();
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
*/
/*
public class Solution
{
    public static void main(String[] args)
    {
        // напишите тут ваш код
    }
}
*/