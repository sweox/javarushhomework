package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int k = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        while(inputStream.available() > 0) {
            int read = inputStream.read();
            if (map.containsKey(read)) {
                for(Map.Entry<Integer, Integer> m:map.entrySet()) {
                    if(m.getKey().equals(read)) {
                        m.setValue(m.getValue()+1);
                    }
                }
            }
            else
                map.put(read, k);
        }

        int max = 0;
        for(Map.Entry<Integer, Integer> m:map.entrySet()) {
            if (m.getValue() >= max)
            {
                max = m.getValue();
            }
        }


//        if (map.containsValue(max)) {
        for(Map.Entry<Integer, Integer> m:map.entrySet()) {
            if(m.getValue().equals(max))
                System.out.print(m.getKey() + " ");
        }
//        }
        reader.close();
        inputStream.close();
    }

}

/*

public class Solution {
    public static void main(String[] args) throws Exception {
    }
}
*/


/*
1. Читаю файл сразу в HashMap, если ключ (байт) уже есть увеличиваю значение, если нет
добавляю со значением 1.
2. Итератором прохожусь по карте в поисках максимального и вывожу его в строку,
если нахожу равное максимальному плюсую в строку.
3. Вывожу строку.
//=========================================================
HashMap имеет встроенные итераторы, такие, что вы можете получить список всех ключей keySet(),
всех значений values() или же все пары ключ/значение entrySet(). Ниже представлены некоторые
варианты для перебора элементов:
// 1.
for (Map.Entry<String, String> entry: hashmap.entrySet())
    System.out.println(entry.getKey() + " = " + entry.getValue());

// 2.
for (String key: hashmap.keySet())
    System.out.println(hashmap.get(key));

// 3.
Iterator<Map.Entry<String, String>> itr = hashmap.entrySet().iterator();
while (itr.hasNext())
    System.out.println(itr.next());
*/

