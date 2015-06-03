package com.javarush.test.level04.lesson16.home04;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String name = read.readLine();
        String y = read.readLine();
        String m = read.readLine();
        String d = read.readLine();
        System.out.println("Меня зовут " + name);
        System.out.print("Я родился " + d + "." + m + "." + y);
    }
}
