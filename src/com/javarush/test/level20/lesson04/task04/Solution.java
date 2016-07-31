package com.javarush.test.level20.lesson04.task04;

import java.io.*;

/* Как сериализовать static?
Сделайте так, чтобы сериализация класса ClassWithStatic была возможной
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;
        public void
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        FileOutputStream fos = new FileOutputStream("c:/4.txt");
        FileInputStream fis = new FileInputStream("c:/4.txt");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        ObjectInputStream in = new ObjectInputStream(fis);

        ClassWithStatic c = new ClassWithStatic();
        c.i = 3;
        c.j = 4;
        System.out.println(c.staticString + " " + c.i + " " + c.j);
        out.writeObject(c);

        c.i = 7;
        c.j = 7;
        c.staticString = "yer";
        System.out.println(c.staticString + " " + c.i + " " + c.j);

         c = (ClassWithStatic) in.readObject();

        System.out.println(c.staticString + " " + c.i + " " + c.j);
        //System.out.println(cLoad.staticString + " " + c.i + " " + c.j);
        //System.out.println(Solution.ClassWithStatic.staticString.equals(cLoad.staticString));
    }
}
