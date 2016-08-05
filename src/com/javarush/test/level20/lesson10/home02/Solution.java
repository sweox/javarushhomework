package com.javarush.test.level20.lesson10.home02;

import java.io.*;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно zтипа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable {
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException
    {
        Object obj = objectStream.readObject();


        if(obj instanceof A) {
            return (A)obj;
        }
        else return (B)obj;

    }

    public class A implements Serializable
    {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

}

/*

public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {

        return null;
    }

    public class A {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}

*/
