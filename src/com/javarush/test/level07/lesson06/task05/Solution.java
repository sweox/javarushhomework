package com.javarush.test.level07.lesson06.task05;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++)
        {
            list.add(reader.readLine());
        }
        for (int i = 0; i < 13; i++)
        {
            String tmp = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(0, tmp);
        }
        for (String elem:list)
            System.out.println(elem);
        //for (int i = 0; i < list.size(); i++)
        //{
        //    System.out.println(list.get(i));
        //}


    }
}
