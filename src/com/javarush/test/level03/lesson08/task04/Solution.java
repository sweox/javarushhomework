package com.javarush.test.level03.lesson08.task04;

/* Спонсор - это звучит гордо
Ввести с клавиатуры два имени и вывести надпись:
name1 проспонсировал name2, и она стала известной певицей.
Пример:
Коля проспонсировал Лену, и она стала известной певицей.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader read = new BufferedReader( new InputStreamReader( System.in ));

        String name1 = read.readLine();
        String name2 = read.readLine();

        System.out.print( name1 + " проспонсировал " + name2 + ", и она стала известной певицей.");

    }
}