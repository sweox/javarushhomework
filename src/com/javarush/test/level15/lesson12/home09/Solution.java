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
//        char[] ch = r.toCharArray();
//        for (int i = 0; i < ch.length; i++) {
//            if (ch[i]=='?' || ch[i] == '&')
//            {
//                while ((i<ch.length - 1) && !(ch[i+1] == '&'))
//                {
//                    i++;
//                    System.out.print(ch[i]);
//                }
//                System.out.print(" ");
//            }
//        }
//==================================================
        //System.out.println(r.indexOf("?"));
        String subStr = r.substring(r.indexOf("?") + 1);
        String[] s = subStr.split("&");
        for(String x:s)
        {
            System.out.println(x);
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
