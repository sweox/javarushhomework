package com.javarush.test.level03.lesson08.task01;

/* Как захватить мир
Ввести с клавиатуры число и имя, вывести на экран строку:
«имя» захватит мир через «число» лет. Му-ха-ха!
Пример: Вася захватит мир через 8 лет. Му-ха-ха!

Последовательность вводимых данных имеет большое значение.
*/

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //InputStream inputStream = System.in;
       // Reader inputStreamReader = new InputStreamReader();
       // BufferedReader bufferedReader = new BufferedReader();

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ));

        String Year = bufferedReader.readLine();
        String name = bufferedReader.readLine();
        int intYear = Integer.parseInt(Year);

        System.out.print( name + " захватит мир через " + intYear + " лет. Му-ха-ха!");

    }
}