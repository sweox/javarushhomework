package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/
/**
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Написать тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        ArrayList<Character> chet = new ArrayList<Character>();
        ArrayList<Character> nechet = new ArrayList<Character>();

        char[] arrStr = str.toCharArray();

            for (int i = 0; i <= arrStr.length; i++)
            {
                if (isVowel(arrStr[i]) == true)
                    chet.add(arrStr[i]);
                else
                {
                    if (arrStr[i] != ' ')
                        nechet.add(arrStr[i]);
                }
                //isVowel(x)?chet.add(x):nechet.add(x);
            }

        //Вывод на экран
        for (char c : chet)
            System.out.print(c + " ");
        System.out.println();
        for (char h : nechet)
            System.out.print(h + " ");
        System.out.println();
        //----------------
        //String str;
        //while (true)
        //{
        //   str = reader.readLine();
        //    if (str.isEmpty())
        //       break;
        //    System.out.println(str);
        //}
        //----------------
        //while (reader.readLine() != str.isEmpty())

    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Написать тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        char[] arrStr = str.toCharArray();

            for (int i = 0; i < arrStr.length; i++)
            {
                if (isVowel(arrStr[i]))
                    System.out.print(arrStr[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < arrStr.length; i++)
                if (!isVowel(arrStr[i])& arrStr[i]!= ' ')
                    System.out.print(arrStr[i] + " ");
    }

    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
/**
Character.toString(char)
        for (int i=0; i < line.length(); i++)
        {
            char symbol = line.charAt(i);
            if (!Character.isSpaceChar(symbol))
                {
                    if (isVowel(symbol)) strGL = strGL+symbol+" ";else strSGL=strSGL+symbol+" ";
                }
        }
 */