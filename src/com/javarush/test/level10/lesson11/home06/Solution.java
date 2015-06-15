package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него.
 Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        private String first_name;
        private int age;
        private String last_name;
        private String otchestvo;
        private int age_son;
        private int age_doch;
//1
        public Human(int age)
        {
            this.age = age;
        }
        //2
        public Human (String first_name, int age)
        {
            this.first_name = first_name;
            this.age = age;
        }
        //3
        public Human (String last_name)
        {
            this.last_name = last_name;
        }
        //4
        public Human(String last_name, String otchestvo)
        {
            this.last_name = last_name;
            this.otchestvo = otchestvo;
        }
        //5
        public Human(int age_son, String first_name)
        {
            this.age_son = age_son;
            this.first_name = first_name;
        }
        //6
        public Human (int age_son, int age_doch)
        {
            this.age_son = age_son;
            this.age_doch = age_doch;
        }
        //7
        public Human(String last_name, String first_name, String otchestvo)
        {
            this.last_name = last_name;
            this.first_name = first_name;
            this.otchestvo = otchestvo;
        }
        //8
        public Human(int age, String last_name, String first_name)
        {
            this.age = age;
            this.last_name = last_name;
            this.first_name = first_name;
        }
        //9
        public Human(String last_name, String first_name, int age)
        {
            this.last_name = last_name;
            this.first_name =  first_name;
            this.age = age;
        }
        //10
        public Human (String last_name, String first_name, String otchestvo, int age_son)
        {
            this.last_name = last_name;
            this.first_name = first_name;
            this.otchestvo = otchestvo;
            this.age_son = age_son;
        }
    }
}
