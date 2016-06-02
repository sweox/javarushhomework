package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if(data >= 0 & data < 128)
            {
                if (treeMap.containsKey(data))
                {
                    treeMap.put(data, (treeMap.get(data) + 1));
                } else
                    treeMap.put(data, 1);
            }
        }
        for(Map.Entry<Integer, Integer> m:treeMap.entrySet()) {
            System.out.println((char)((int)m.getKey()) + " " + m.getValue());
        }
        fileInputStream.close();

    }
}

/*
//==========================================================
import java.io.FileInputStream;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) throws IOException
    {

        FileInputStream fileInputStream = new FileInputStream(args[0]);

        int[] intM = new int[128];

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            intM[data] = intM[data] + 1;
        }
        for(int i = 0; i < intM.length; i++) {
            if(intM[i] > 0)
                System.out.println((char)i + " " + intM[i]);
        }
        fileInputStream.close();

    }
}
*/


/*
//==================================================================
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String str = reader.readLine();

        int[] intM = new int[128];
        for(int i = 0; i < str.getBytes().length; i++) {
            intM[(int)str.charAt(i)] = intM[(int)str.charAt(i)] + 1;
        }
        for(int i = 0; i < intM.length; i++) {
            if(intM[i] > 0)
                System.out.println((char)i + " " + intM[i]);
        }
        reader.close();
    }
}
*/


/*
public class Solution {
    public static void main(String[] args) throws IOException {
    }
}
*/
