package test.test.ArrayList_vs_LinkedList;

import java.util.*;

public class Series {

    List al = new ArrayList();
    List ll = new LinkedList();

    void addAL() {

        for (int i = 0; i < 1000000; i++)
            al.add(al.size()/2, 10);
    }

    void addLL() {

        for (int i = 0; i < 1000000; i++)
            ll.add(ll.size()/2, 10);
    }

    void info() {
        System.out.println(al.size() + " " + ll.size());
    }

    public static void main(String[] args) {

        Series s = new Series();
        long start = System.nanoTime();
        s.addAL();
        long duration = System.nanoTime() - start;
        System.out.println(duration);

        start = System.nanoTime();
        s.addLL();
        duration = System.nanoTime() - start;
        System.out.println(duration);

        s.info();
    }
}