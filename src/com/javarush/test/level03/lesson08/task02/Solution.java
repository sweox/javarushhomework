package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры Имя и два числа, вывести надпись:
name1 получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader rea = new BufferedReader( new InputStreamReader( System.in ));

        String name1 = rea.readLine();

        String Number1 = rea.readLine();
        String Number2 = rea.readLine();

        int intNumber2 = Integer.parseInt(Number2);
        int intNumber1 = Integer.parseInt(Number1);

        System.out.println( name1 + " получает " + intNumber1 + " через " + intNumber2 + " лет.");


    }
}