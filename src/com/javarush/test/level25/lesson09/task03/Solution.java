package com.javarush.test.level25.lesson09.task03;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/

import java.util.ArrayList;
import java.util.Iterator;

public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        ArrayList<Throwable> list = new ArrayList<>();
        Throwable x = e;
        while (x != null) {
            list.add(0, x);
            x = x.getCause();
        }
        Iterator it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

//    public static void main(String[] args) {
//
//        Thread thread = new Thread() {
//            public void run() {
//                    throw new RuntimeException("ABC", new Error());
//            }
//        };
//        thread.setUncaughtExceptionHandler(new Solution());
//        thread.start();
//
//
//    }
}




/*
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
    }
}
*/
