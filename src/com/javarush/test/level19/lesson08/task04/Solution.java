package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baos);

        System.setOut(stream);

        testString.printSomething();

        String str = baos.toString();
        String[] strArr = str.split(" ");

        System.setOut(consoleOut);

        System.out.println(strArr[0] + " " + strArr[1] + " " + strArr[2] + " " + strArr[3] + " " + solu(strArr));

    }
    public static int solu(String[] arr) {
        int result = 0;
        if (arr[1].equals("+")) {
            result = Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]);
        }
        if (arr[1].equals("-")) {
            result = Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]);
        }
        if (arr[1].equals("*")) {
            result = Integer.parseInt(arr[0]) * Integer.parseInt(arr[2]);
        }
        return result;
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

/*

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

*/
