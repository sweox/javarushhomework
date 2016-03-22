package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();

        while(inputStream.available() > 0) {
            list.add(inputStream.read());
        }
        System.out.println(minMethod(list));

        reader.close();
        inputStream.close();
    }
    public static int minMethod(ArrayList<Integer> list) {
        int a = list.get(0);
        for (int l:list) {
            if (l < a) a = l;
        }
        return a;
    }
}

/*

public class Solution {
    public static void main(String[] args) throws Exception {
    }
}
*/
