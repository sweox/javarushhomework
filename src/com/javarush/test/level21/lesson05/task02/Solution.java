package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        /*return (first == null ? n.first == null : first.equals(n.first)) &&
                (last != null ? n.last.equals(last) : n.last == null);*/
        if(first != null ? !n.first.equals(first) : n.first != null)
            return false;
        if(last != null ? ! last.equals(n.last) : n.last != null)
            return false;
        return true;

    }
    public int hashCode() {
        return 31 * (first == null ? 0 : first.hashCode())
                + (last != null ? last.hashCode() : 0);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}


/*

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        return n.first.equals(first) && n.last.equals(last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
*/
