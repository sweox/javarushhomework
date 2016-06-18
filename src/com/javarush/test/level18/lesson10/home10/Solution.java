package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        Map<Integer, byte[]> treeMap = new TreeMap<>();
        String[] spl = new String[3];
        while(!(fileName = reader.readLine()).equals("end")) {
             spl = fileName.split("\\.");
            FileInputStream inputStream = new FileInputStream(fileName);
                byte[] readByte = new byte[inputStream.available()];
                inputStream.read(readByte);
                treeMap.put(getNumberFromString(spl[2]), readByte);
            inputStream.close();

        }
        FileOutputStream outputStream = new FileOutputStream(spl[0] + "." + spl[1]);
        Iterator<Map.Entry<Integer, byte[]>> f = treeMap.entrySet().iterator();
        while(f.hasNext()) {
            Map.Entry<Integer, byte[]> set = f.next();
            outputStream.write(set.getValue());
        }
        outputStream.close();
        reader.close();
    }
    public static Integer getNumberFromString(String element) {
        return Integer.parseInt(element.substring(4));
    }
}
