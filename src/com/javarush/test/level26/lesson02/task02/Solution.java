package com.javarush.test.level26.lesson02.task02;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* Был бы ум - будет и успех.
Солдаты всегда строились, строятся и будут строиться по убыванию роста.
Отсортируйте солдат, предварительно подумав, что лучше использовать при таких условиях - Comparable или Comparator.
*/


public class Solution {
    public static void main(String[] args) {
        Set<Soldier> soldiers = new TreeSet<>(new Comparator<Soldier>() {
            public int compare(Soldier s1, Soldier s2) {
                return s2.height - s1.height;
            }
        });
        soldiers.add(new Soldier("Ivanov", 170));
        soldiers.add(new Soldier("Petrov", 180));
        soldiers.add(new Soldier("Sidorov", 175));

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.name);
        }
    }

    public static class Soldier implements Comparable<Soldier> {
        private String name;
        private int height;

        public Soldier(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public int compareTo(Soldier s) {
            return s.height - this.height;
        }
    }
}


/*
public class Solution {
    public static void main(String[] args) {
        Set<Soldier> soldiers = new TreeSet<>();
        soldiers.add(new Soldier("Ivanov", 170));
        soldiers.add(new Soldier("Petrov", 180));
        soldiers.add(new Soldier("Sidorov", 175));

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.name);
        }
    }

    public static class Soldier {
        private String name;
        private int height;

        public Soldier(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
}
*/
