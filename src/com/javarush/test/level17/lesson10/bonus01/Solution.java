package com.javarush.test.level17.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/


public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1


    }



    public static void main(String[] args) throws ParseException, IOException
    {
        //start here - начни тут



            if (args[0].equals("-c"))
            {
                Person addPerson;
                if (args[2].equals("м"))
                {
                    addPerson = Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3]));
                    allPeople.add(addPerson);
                } else
                {
                    addPerson = Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3]));
                    allPeople.add(addPerson);
                }
                System.out.println(allPeople.indexOf(addPerson));
            }

            if (args[0].equals("-u"))
            {


                Person old = allPeople.get(Integer.parseInt(args[1]));
                Person change;

                if (args[3].equals("м"))
                {
                    change = Person.createMale(args[2], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]));
                    old.setName(change.getName());
                    old.setSex(change.getSex());
                    old.setBirthDay(change.getBirthDay());
                } else
                {
                    change = Person.createFemale(args[2], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4]));
                    old.setName(change.getName());
                    old.setSex(change.getSex());
                    old.setBirthDay(change.getBirthDay());
                }


            }
            if (args[0].equals("-d"))
            {
                Person forLogRemone = allPeople.get(Integer.parseInt(args[1]));
                forLogRemone.setBirthDay(null);
                forLogRemone.setName(null);
                forLogRemone.setSex(null);
            }
            if (args[0].equals("-i"))
            {
                String sexFromEnum;
                Person getPerson = allPeople.get(Integer.parseInt(args[1]));
                if (getPerson.getSex() == Sex.MALE)
                {
                    sexFromEnum = "м";
                } else
                    sexFromEnum = "ж";
                System.out.println(getPerson.getName() + " " + sexFromEnum + " " +
                        new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(getPerson.getBirthDay()));
            }





    }
}
