package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый
кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        //Написать тут ваш код. step 3 - пункт 3
        //Iterator it = cats.iterator();
        //if (it.hasNext())
            cats.remove(cats.iterator().next());

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        //Написать тут ваш код. step 2 - пункт 2
        Set<Cat> createCats = new HashSet<Cat>();
        createCats.add(new Cat());
        createCats.add(new Cat());
        createCats.add(new Cat());

        return createCats;
    }

    public static void printCats(Set<Cat> cats)
    {
        // step 4 - пункт 4
        for (Cat x:cats)
        {
            System.out.println(x);
        }
    }

    // step 1 - пункт 1
    public static class Cat
    {

    }
}


/**
public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        //Написать тут ваш код. step 3 - пункт 3

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        //Написать тут ваш код. step 2 - пункт 2
        return null;
    }

    public static void printCats(Set<Cat> cats)
    {
        // step 4 - пункт 4
    }

    // step 1 - пункт 1
}
*/