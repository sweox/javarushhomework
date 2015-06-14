package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).
Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(int i=0;i<32;i++)
        {
            alphabet.add( (char) ('а'+i));
        }
        alphabet.add(6,'ё');

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<10;i++)
        {
            String s = reader.readLine();
            list.add( s.toLowerCase());
        }
        //System.out.print(list);


        //Напишите тут ваш код
        //Преобразование строк в список символов
        ArrayList<Character> ch = new ArrayList<Character>();   //Массив для символов
        for (int i = 0; i < list.size(); i++)
        {
            String s = list.get(i); //перебираем строки
            for (int j = 0; j < s.length(); j++)
            {
                char c = s.charAt(j);   //перебираем символы в строке
                ch.add(c);  //Добавляем в массив для символов
            }
        }
        //Подсчет количества символов в введенных строках
        ArrayList<Integer> intChar = new ArrayList<Integer>(); //Массив для колличества символов
        for (int k = 0; k < alphabet.size(); k++)
        {
            int quantity = 0; // Инициализация счетчика символов
            for (int l = 0; l < ch.size(); l++)
            {
                if (alphabet.get(k).equals(ch.get(l)))  //Проверка на равенство
                {
                    quantity++;
                }
            }
            intChar.add(k, quantity); //Запись количесива символов в список
        }
        //=======================================
        //Вывод колличества букв в строках
        for (int n = 0; n < alphabet.size(); n++)
        {
            System.out.println(alphabet.get(n) + " " + intChar.get(n));
        }
    }
}
/**
    int[] count = new int[33];

    for(int i = 0; i < list.size(); i++)
    {
        for(int k = 0; k < list.get(i).length(); k++)
        {
            for(int j = 0; j < alphabet.size(); j++)
            {
                if(list.get(i).charAt(k) == alphabet.get(j))
                {
                    count[j] = count[j] + 1;
                }
            }
        }
    }
    for(int i = 0; i < alphabet.size(); i++)
    {
        System.out.println(alphabet.get(i) + " " + count[i]);
    }
//=====================================
 int count = 0;
 //суперциклы. И че я так долго думал над этим?
 //сначала по алфавиту, потом по строке, потом по символу строки.
 for (char abs : alphabet)
 {
    for (String lonelyString : list)
    {
        for (char symbol : lonelyString.toCharArray())
        {
            if(abs == symbol)
            count++;
        }
    }
 System.out.println(abs + " " + count);
 count = 0;
 }
//=======================================
 for (int i = 0; i < alphabet.size();i++)
 {
    int count = 0;
    for (int x = 0; x<chars.length;x++)
    {
        if (alphabet.get(i)== chars[x])
        {
            count++;
        }
    }

 System.out.println(alphabet.get(i)+" "+ count);
 }
 //=====================================
 String str = list.toString();
 for (int i = 0; i < alphabet.size(); i++)
 {
    int count = str.split(alphabet.get(i) + "").length;
    counter[i] = count - 1;
 }

//=========================================
//Данный код найдет частоту вхождения всех символов в тексте.
 //       Хоть и не по условию, и решение не пройдет, но получилось изящно. И всего с одним циклом

        String s = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        HashMap <Character , Integer> alphabet = new HashMap<Character , Integer>();
        for ( Character i : s.toCharArray() )
        {
            Integer count = alphabet.get( i );
            if (count == null)
                count = 0;
            alphabet.put( i , count + 1 );
        }

        for (Map.Entry<Character , Integer> i : alphabet.entrySet())
        System.out.println(i.getKey() + " " + i.getValue());
 */