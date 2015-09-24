package com.javarush.test.level14.lesson08.home03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* User, Looser, Coder and Proger
1. Ввести [в цикле] с клавиатуры несколько строк (ключей).
Строки(ключи) могут быть такими: "user", "looser", "coder", "proger".
Ввод окончен, когда строка не совпадает ни с одной из выше указанных.

2. Для каждой введенной строки нужно:
2.1. Создать соответствующий объект [см Person.java], например, для строки "user" нужно
создать объект класса User.
2.2. Передать этот объект в метод doWork.

3. Написать реализацию метода doWork, который:
3.1. Вызывает метод live() у переданного обекта, если этот объект (person) имеет тип User.
3.2. Вызывает метод doNothing(), если person имеет тип Looser.
3.3. Вызывает метод coding(), если person имеет тип Coder.
3.4. Вызывает метод enjoy(), если person имеет тип Proger.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        //key = reader.readLine();
        while ((key=reader.readLine()).equals("user")||
                key.equals("looser")||key.equals("coder")
                ||key.equals("proger"))
        {
        //создаем объект, пункт 2
            if (key.equals("user"))
                person = new Person.User();
            if (key.equals("coder"))
                person = new Person.Coder();
            if (key.equals("looser"))
                person = new Person.Looser();
            if (key.equals("proger"))
                person = new Person.Proger();

        doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person)
    {
        // пункт 3
        //new Person.User().live();
        if (person instanceof Person.User)
            ((Person.User)person).live();
        if (person instanceof Person.Coder)
            ((Person.Coder)person).coding();
        if (person instanceof Person.Looser)
            ((Person.Looser)person).doNothing();
        if (person instanceof Person.Proger)
            ((Person.Proger)person).enjoy();
    }
}
/*
Особенность вызова вложенных классов. Был бы Person статичным классом, можно было писать
просто new User(). А так, нужно сначала внешний объект инициализировать, а потом уже внутренний.
--------------
http://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
http://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html
*/

/*
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        {
            //создаем объект, пункт 2

            doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person)
    {
        // пункт 3
    }
}
*/