package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        try {
//            Pair pair;
            ArrayList<String> list = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while (fileReader.ready()) {
                list.addAll(Arrays.asList(fileReader.readLine().split(" ")));
            }
            System.out.println(list);
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(i) == null || list.get(j) == null) {
                        continue;
                    }
                    if (list.get(i).equals(new StringBuilder(list.get(j)).reverse().toString()) && i != j) {
                        Pair pair = new Pair();
                        pair.first = list.get(i);
                        pair.second = list.get(j);
                        result.add(pair);
                        list.set(i, null);
                        list.set(j, null);
                    }
                }
            }
            System.out.println(result);
        }
        catch (IOException e) {}
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
