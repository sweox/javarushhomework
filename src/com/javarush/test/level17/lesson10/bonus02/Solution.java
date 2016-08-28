package com.javarush.test.level17.lesson10.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
        System.out.println("Before Thread");
        new ConcThread().start();
        System.out.println("After thread");
    }

    public static void main(String[] args) {
        //start here - начни тут

        //String [] str = {"-c", "Миронов", "м", "15/04/1990", "Миронова", "ж", "15/04/1990"};
        //args = str;
        String[] arCopyWithOutZeroIndex = arrayCopyMinusZerroPosition(args);


        try {
        switch (args[0]) {
            case "-c": {
                addPeople(arCopyWithOutZeroIndex);
                break;
            }
            case "-u": {
                updatePeople(arCopyWithOutZeroIndex);
                break;
            }
            case "-d": {

                break;
            }
            case "-i": {

                break;
            }


        }
    }
    catch (ParseException e) {}
    }
     static SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    static void addPeople(String... strAr) throws ParseException
    {
        Person person = null;
        for (int i = 0; i < strAr.length; i += 3) {
            if (strAr[i + 1].equals("м")) {
                person = Person.createMale(strAr[i], date.parse(strAr[i + 2]));
            }
            else {
                person = Person.createFemale(strAr[i], date.parse(strAr[i + 2]));
            }
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
    }
    static void updatePeople(String[] strAr) throws ParseException
    {
        for (int i = 0; i < strAr.length; i+=3) {
            Person updPerson = allPeople.get(Integer.parseInt(strAr[i]));
            updPerson.setName(strAr[i + 1]);
            updPerson.setBirthDay(date.parse(strAr[i + 3]));
            if (strAr[i + 2].equals("м")) {

                updPerson.setSex(Sex.MALE);
            }
            else {
                updPerson.setSex(Sex.FEMALE);
            }
        }

    }
    static void logicDeletePeople() {

    }
    static void infoIdPeople() {

    }
    static String[] arrayCopyMinusZerroPosition(String[] srs) {
        String[] dst = new String[srs.length - 1];
        System.arraycopy(srs, 1, dst, 0, srs.length - 1);
        return dst;
    }
}

class ConcThread extends Thread {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public void run() {

        //try
        //{
            //String s = reader.readLine();
            //String[] argsCopy = reader.readLine().split(" ");
            String [] str = {"-c", "Миронов", "м", "15/04/1990", "Миронова", "ж", "15/04/1990"};
            //Solution.main(argsCopy);
            Solution.main(str);
        //}
        //catch (IOException e) {}

    }
}