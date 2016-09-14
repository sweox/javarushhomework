package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена

Washington Moscow Windhoek Krakow
Washington Moscow
Amsterdam Malta Malaga
"ab", "ca", "bd", "db", "bc", "ba"
wn mw ks wk kw
*/
public class Solution {
    public static void main(String[] args) {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        ArrayList<String> list = new ArrayList<>();
        try {
            fileName = reader.readLine();
            reader.close();

            BufferedReader r = new BufferedReader(new FileReader(fileName));
            while (r.ready()) {
                list.addAll(Arrays.asList(r.readLine().split(" ")));
            }
        }
        catch(IOException e) {}

        String[] strArr = new String[list.size()];
        list.toArray(strArr);
        StringBuilder result = getLine(strArr);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();

        if (words == null) {
            return builder;
        }
        ArrayList<String> strArr = new ArrayList<>();
        Collections.addAll(strArr, words);

        String tmp = "";
        while(!strArr.isEmpty()) {
            for (int i = 0; i < strArr.size(); i++) {
                tmp = strArr.get(i);
                if (builder.toString().equals("")) {
                    builder.append(tmp);
                    strArr.remove(i);

                }
                else if(builder.toString().toLowerCase().charAt(builder.toString().length() - 1)
                        == strArr.get(i).toLowerCase().charAt(0)) {
                    builder.append(" ").append(strArr.get(i));
                    strArr.remove(i);

                }
            }
        }
          return builder;
    }
}
