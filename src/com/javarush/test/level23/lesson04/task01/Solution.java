package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution sol1 = new Solution();
        Solution sol2 = new Solution();

        sol1.innerClasses[0] = sol1.new InnerClass();
        sol1.innerClasses[1] = sol1.new InnerClass();

        sol2.innerClasses[0] = sol2.new InnerClass();
        sol2.innerClasses[1] = sol2.new InnerClass();

        Solution[] solFoRet = new Solution[2];
        solFoRet[0] = sol1;
        solFoRet[1] = sol2;

        return solFoRet;
//        return new Solution[] {sol1, sol2};
    }
}

/*

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        return null;
    }
}
*/
