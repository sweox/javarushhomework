package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и
разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String r = reader.readLine();
        ArrayList<String> list = new ArrayList<String>();
//==================================================
        String subStr = r.substring(r.indexOf("?") + 1);
        String[] subStrSplit = subStr.split("&");
        String[] _x = null;
        for (int i = 0; i < subStrSplit.length; i++)
        {
            if (subStrSplit[i].contains("=")) {
                _x = subStrSplit[i].split("=");
                System.out.print(_x[0]);
                if (_x[0].equals("obj")) {
                    list.add(_x[1]);
                }
            }
            else
                System.out.print(subStrSplit[i]);
            if (i < subStrSplit.length - 1)
                System.out.print(" ");
            if ((i == subStrSplit.length - 1))
                System.out.println();
        }

        for (int i = 0; i < list.size(); i++)
        {
            try{
                alert(Integer.parseInt(list.get(i)));
            }
            catch (NumberFormatException e) {
                if (list.get(i).contains(".")) {
                alert(Double.parseDouble(list.get(i)));
            }
                else
                    alert(list.get(i));
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
*/
