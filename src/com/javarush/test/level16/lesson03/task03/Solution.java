package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        //System.out.println(list.size());
        SpecialThread spec1 = new SpecialThread();
        SpecialThread spec2 = new SpecialThread();
        SpecialThread spec3 = new SpecialThread();
        SpecialThread spec4 = new SpecialThread();
        SpecialThread spec5 = new SpecialThread();
        list.add(new Thread(spec2));
        list.add(new Thread(spec1));
        list.add(new Thread(spec3));
        list.add(new Thread(spec4));
        Thread sspec5 = new Thread(spec4);
        list.add(sspec5);
        //System.out.println(list.size());
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}

/*
public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
*/
