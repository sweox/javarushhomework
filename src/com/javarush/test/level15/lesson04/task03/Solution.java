package com.javarush.test.level15.lesson04.task03;

/* ООП - Перегрузка - убираем лишнее
1. Подумайте, какая из реализаций метода print будет вызвана.
2. Удалите все лишние реализации метода print.
*/

//То есть, цепочка расширения выглядит так: byte >> short >> int >> long >> float >> double
//Целочисленные константы могут задаваться в программе одним из трех способов: в виде десятичных, шестнадцатеричных и
//восьмеричных значений. По умолчанию все числа интерпретируются как десятичные и относятся к типу int. Явно
//указать принадлежность к типу long можно, добавив в конце числа букву „l“ или букву „L“. „

public class Solution {
    public static void main(String[] args) {
        print(1);
    }

//    public static void print(byte b) {
//        System.out.println("Я буду Java прогером!");
//    }

//    public static void print(double d) {
//        System.out.println("Я буду Java прогером!");
//    }

    public static void print(long l) {
        System.out.println("Я буду Java прогером!");
    }

//    public static void print(float f) {
//        System.out.println("Я буду Java прогером!");
//    }

//    public static void print(char c) {
//        System.out.println("Я буду Java прогером!");
//    }
}

/*

public class Solution {
    public static void main(String[] args) {
        print(1);
    }

    public static void print(byte b) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(double d) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(long l) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(float f) {
        System.out.println("Я буду Java прогером!");
    }

    public static void print(char c) {
        System.out.println("Я буду Java прогером!");
    }
}
*/
