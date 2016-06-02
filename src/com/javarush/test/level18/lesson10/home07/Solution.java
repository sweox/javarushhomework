package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        int idName = Integer.parseInt("6");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
        String[] strM = new String[Character.MAX_VALUE];
        String readL;
        while(!(readL = readerFile.readLine()).equals("null")) {
            int count = 0;
            strM[count] = readL;
            count++;
        }
        readerFile.close();
        System.out.println(Arrays.toString(strM));
        for(String s:strM) {
            if(searh(s, idName)) {
                System.out.println(s);
            }
        }
    }
    public static boolean searh(String str, int id) {
        boolean tmpBoolean = false;
        String[] tmpStr = str.split(" ");
        if(id == Integer.parseInt(tmpStr[0])) {
            tmpBoolean = true;
        }
        return tmpBoolean;
    }
}
