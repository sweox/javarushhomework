package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int key = 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        while(inputStream.available() > 0) {
            int tmp = inputStream.read();
            if (map.containsKey(tmp)) {
                for (Map.Entry<Integer, Integer> m:map.entrySet()) {
                    if (m.getKey().equals(tmp)) {
                        m.setValue(m.getValue() + 1);
                    }
                }
            }
            else {
                map.put(tmp, key);
            }
        }

        int max = 0;
        for(Integer inter:map.keySet()) {
            if (map.get(inter) > max) {
                max = map.get(inter);
            }
        }

        int min = max;
        for(Integer keys:map.keySet()) {
            if (map.get(keys) < min) {
                min = map.get(keys);
            }
        }

        for (Map.Entry<Integer, Integer> m:map.entrySet()) {
            if (m.getValue().equals(min)) {
                System.out.print(m.getKey() + " ");
            }
        }
        reader.close();
        inputStream.close();
    }

}
