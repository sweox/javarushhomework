package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerInput = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(readerInput.readLine());
        BufferedReader readData = new BufferedReader(fileReader);
        int count = 0;
        while(readData.ready()) {
            String[] mas = readData.readLine().split(" ");
            for(String str:mas) {
                if(str.toLowerCase().equals("world") || str.toLowerCase().equals("world.")
                        || str.toLowerCase().equals("world,")) {
                    count++;
                }
            }
        }
        readerInput.close();
        fileReader.close();
        readData.close();
        System.out.println(count);
    }
}

/*
    String[] s = fileReader.readLine().split("[., !?;:-]");
//--------------------------------
    str = str.replaceAll("\\p{Punct}", " ");
        str = str.replaceAll("\n", " ");
//----------------------------
*/


/*
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerInput = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(readerInput.readLine());
        BufferedReader readData = new BufferedReader(fileReader);
        int count = 0;
        while(readData.ready()) {
            String[] mas = readData.readLine().split(" ");
            for(String str:mas) {
                if(str.toLowerCase().equals("world") || str.toLowerCase().equals("world.")
                        || str.toLowerCase().equals("world,")) {
                    count++;
                }
            }
        }
        readerInput.close();
        fileReader.close();
        readData.close();
        System.out.println(count);
    }
}
*/
