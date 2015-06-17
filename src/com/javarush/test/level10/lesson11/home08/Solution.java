package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и
вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //Напишите тут ваш код
/**
//-----------------1-й способ------------
        ArrayList<String>[] list = new ArrayList[2];    //Создаем массив

        ArrayList<String> list1 = new ArrayList<String>();  //Создаем строку
        list1.add("1"); //Инициализируем строку
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("2");
        //Добавляем строки в массив так
        list[0] = list1;    //Добавляем строки в массив
        list[1] = list2;
        //Или добавляем так
        //ArrayList<String>[] list = new ArrayList[]{list1, list2};
*/
//--------------2-й способ( доделан)-----------------
        int a = 2;  //Количество строк в массиве
        int b = 4;  //Количество элементов в строке

        ArrayList<String>[] list = new ArrayList[a];    //Создаем массив элементов из списков
        for (int i = 0; i < list.length; i++)
        {
            list[i] = new ArrayList<String>();  //Инициализируем элементы массива (списка)
            for (int j = 0; j < b; j++)
            {
                list[i].add("Привет " + i + " " + j);   //Заполняем список элементами
            }
        }

/**
//===============================================================================
//http://prologistic.com.ua/kak-sozdat-i-initsializirovat-list-v-odnu-stroku-na-java.html
        //Про List создание и инициализация в одной строке
        package ua.com.prologistic.arraylistdemo;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;


        public class ArrayListDemo{

            public static void main(String args[]) {

                //Здесь происходит привычное создание и инициализация массива в одну строку
                String[] coolStringArray = new String[]{"Java" , "Scala" , "Groovy"};
                System.out.println(" Array : " + Arrays.toString(coolStringArray));

                //Теперь вручную создадим ArrayList с тремя элементам
                List<String> notSoCoolStringList = new ArrayList<String>();
                notSoCoolStringList.add("Java");
                notSoCoolStringList.add("Scala");
                notSoCoolStringList.add("Groovy");

                //На это нам потребовалось 4 строки
                System.err.println(" List : " + notSoCoolStringList);

                //Здесь происодит создание и инициализация List в одну строку
                List<String> coolStringList = Arrays.asList("Java", "Scala", "Groovy");
                System.err.println(" List создан и инициализирован в одну строку : " + coolStringList);
            }
        }
 */
        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}