package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFile = new BufferedReader(new FileReader(readerConsole.readLine()));
/*
        while(readerFile.ready()) {
            Set<String> set = new HashSet<>();
            String str = readerFile.readLine();
            String[] strArr = str.split(" ");
            for(String s : strArr) {
                if(words.contains(s)) {
                    set.add(s);
                }
            }
            if(set.size() == 2) {
                System.out.println(str);
            }
        }
 */
        while(readerFile.ready()) {
            String str = readerFile.readLine();
            String strArr[] = str.split(" ");
            int tmp = 0;
            for(int i = 0; i < words.size(); i++) {
                for(int j = 0; j < strArr.length; j++) {
                    if(words.get(i).equals(strArr[j])) {
                        tmp = tmp + 1;
                    }
                }


            }
            if(tmp == 2)
            System.out.println(str);
        }
        readerConsole.close();
        readerFile.close();
    }
}

//Почему-то этот вариант не прошел тестирование
/*

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFile = new BufferedReader(new FileReader(readerConsole.readLine()));
        while(readerFile.ready()) {
            String str = readerFile.readLine();
            String strArr[] = str.split(" ");
            int a = 0;
            int b = 0;
            int c = 0;

            for(int i = 0; i < words.size(); i++) {
                int tmp = 0;


                for(int j = 0; j < strArr.length; j++) {
                    if(words.get(i).equals(strArr[j])) {
                        tmp = tmp + 1;
                    }
                }

                if (i == 0)
                    a = tmp;
                else if(i == 1)
                    b = tmp;
                else c = tmp;

            }
            if((a + b + c) == 2)
                System.out.println(str);
        }
        readerConsole.close();
        readerFile.close();
    }
}
*/
