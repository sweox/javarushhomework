package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //Напишите тут ваш код
        Map<String, Cat> map = new HashMap<String,Cat>();
        map.put("1", new Cat("1_1"));
        map.put("2", new Cat("2_2"));
        map.put("3", new Cat("3_3"));
        map.put("4", new Cat("4_4"));
        map.put("5", new Cat("5_5"));
        map.put("6", new Cat("6_6"));
        map.put("7", new Cat("7_7"));
        map.put("8", new Cat("8_8"));
        map.put("9", new Cat("9_9"));
        map.put("10", new Cat("10_10"));
        return map;
        /**
        Map<String, Cat> mapCat = new HashMap<String, Cat>();
        for (int i = 0; i < 10; i++)
        {
            String name = "Name_" + i;
            mapCat.put(name, new Cat(name)) ;
        }
        return mapCat;
        */
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //Напишите тут ваш код
        Set<Cat> set = new HashSet<Cat>();
        for(Map.Entry<String, Cat> x:map.entrySet())
        {
            //x.getKey();
            set.add(x.getValue());
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
