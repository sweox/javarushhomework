package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        while(readerFile.ready()) {
            String strArr[] = readerFile.readLine().split(" ");
            int a = 0;
            int b = 0;
            int c = 0;

            for(int i = 0; i < words.size(); i++) {
                int tmp = 0;
                if (i == 0)
                    tmp = a;
                else if(i == 1)
                    tmp = b;
                else tmp = c;

                for(int j = 0; j < strArr.length; j++) {
                    if(words.get(i).equals(strArr[j])) {
                        tmp = tmp + 1;
                    }
                }
                System.out.println(a + " " + b + " " + c);
            }
        }
    }
}
