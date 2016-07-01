package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, Double> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while(reader.ready()) {
            String [] strArr = reader.readLine().split(" ");
            if(map.containsKey(strArr[0])) {
                map.put(strArr[0], map.get(strArr[0]) + Double.parseDouble(strArr[1]));
            }
            else
                map.put(strArr[0], Double.parseDouble(strArr[1]));
        }
        reader.close();
        Double maxTmp = 0.0;
        for(Map.Entry<String, Double> m : map.entrySet()) {
            if(m.getValue() > maxTmp) {
                maxTmp = m.getValue();
            }
        }
        for(Map.Entry<String, Double> m : map.entrySet()) {
            if(m.getValue().equals(maxTmp)) {
                System.out.println(m.getKey());
            }
        }
    }
}
/*

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
    }
}
*/
