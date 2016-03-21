package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        while(inputStream.available() > 0) {
            int readInt = inputStream.read();
            list.add(readInt);
        }
        MaxValue maxValue = new MaxValue();
        System.out.println(maxValue.maxValue(list));
        reader.close();

    }
    public static class MaxValue {
        public Integer maxValue(ArrayList<Integer> list) {
            Integer max = list.get(0);
            for (Integer lis : list)
            {
                if (lis > max) {
                    max = lis;
                }
            }
            return max;
        }
    }
}


/*
public class Solution {
    public static void main(String[] args) throws Exception {
    }
}
*/
