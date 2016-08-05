package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/

public class Solution  implements Serializable {
    public static class A {
        protected String name = "A";
        public A() {}
        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
        private void writeObject(ObjectOutputStream out) throws IOException
        {
            out.defaultWriteObject();
            out.writeObject(name);
        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
        {
            in.defaultReadObject();
            name = (String) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution sol = new Solution();
        B b = sol.new B(" : this is B : ");
        System.out.println(b.name);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:/77.txt"));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:/77.txt"));
        out.writeObject(b);
        B bDes = sol.new B(" : B2 : ");
        System.out.println(bDes.name);
        bDes = (B)in.readObject();
        System.out.println(b.name);
        System.out.println(bDes.name);

    }

}

/*

public class Solution {
    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
    }
}
*/

/*

    Не совсем корректно на мой взгляд. static в данном случае не при делах. Если ты напишешь
public static class A implements Serializable
и посмотришь в отладчике значения name до и после сериализации, то они будут идентичны. В
        данной задаче класс А просто не участвует в сериализации. Он лишь является базой
        объекта B.

        Порядок создания объекта B обычном режиме:
        1. Вызывается базовый конструктор А с параметром «В». Сначала он инициализирует
        name значение «A» потом добавляет к ней параметр. Получаем «AB»
        2. Вызывается конструктор наследника, и добавляет к name значение параметра еще
        раз. Получаем «ABB»

        Что происходить во время десериализации объекта B:
        1. Десириализация сначала создает базовую часть объекта B, вызвая дефолтный
        конструктор A() котрый инициализирует name значением «A»
        2. Десириализация пытается создать все что связано непосредственно с наследником
        B, но так как ни дефолный механизм ни какие либо другие механизмы не реализованы,
        этого не проиcходит. И мы получаем десериализованый объект B с name = «A».

        Чтобы это забороть, надо управлять сериализаций\десериализацией класса B
        (наследника). То есть нужно руками сохранить все нужные данные, а потом руками-же их загрузить и ициализировать класс B правильными данными. Как — было в лекциях.

        Это лишь часть проблем с данной задачей. Хорошая задача. Кода минимум, а
        сколько тем затронули. Заставила мозги пошевелиться.
 */
