package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readerData;
        while(!(readerData = reader.readLine()).equals("exit")) {
            new ReadThread(readerData).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            TreeMap<Integer, Integer>  treeMap = new TreeMap<>();
            try
            {
                FileInputStream inputStreamData = new FileInputStream(fileName);
                while(inputStreamData.available() > 0) {
                    int readByte = inputStreamData.read();
                    if(treeMap.containsKey(readByte)) {
                        treeMap.put(readByte, treeMap.get(readByte) + 1);
                    }
                    else
                        treeMap.put(readByte, 1);
                }
                inputStreamData.close();
                int tmpMax = 0;
                int byteMaxValue = 0;
                for(Map.Entry<Integer, Integer> kAndV:treeMap.entrySet()) {
                    if(kAndV.getValue() > tmpMax) {
                        tmpMax = kAndV.getValue();
                        byteMaxValue = kAndV.getKey();
                    }
                }
                resultMap.put(fileName, byteMaxValue);
            }
            catch (IOException e) {}
        }
    }
}

/*

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
*/
