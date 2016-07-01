package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String name = "";
        int day = 0;
        int monts = 0;
        int year = 0;
        while(reader.ready()) {
            String[] strArr = reader.readLine().split(" ");
            name = strArr[0];
            for(int i = 1; i < strArr.length; i++) {
                if(Character.isDigit(strArr[i].toCharArray()[0])) {
                    day = Integer.parseInt(strArr[strArr.length - 3]);
                    monts = Integer.parseInt(strArr[strArr.length - 2]);
                    year = Integer.parseInt(strArr[strArr.length - 1]);
                }
                else
                    name = name + " " + strArr[i];
            }
            PEOPLE.add(new Person(name, new Date(year - 1900, monts - 1, day)));
            //System.out.println(name + " " + day + " " + monts + " " + year);
        }
        reader.close();
//        System.out.println(PEOPLE.get(0).getName() + " " + PEOPLE.get(0).getBirthday());
//        System.out.println(PEOPLE.get(1).getName() + " " + PEOPLE.get(1).getBirthday());
    }

}
/*

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
           }

}
*/
