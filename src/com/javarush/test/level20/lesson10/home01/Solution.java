package com.javarush.test.level20.lesson10.home01;

import java.io.Serializable;

/* Минимум изменений
Используя минимум изменений кода сделайте так, чтобы сериализация класса C стала возможной.
*/

public class Solution {

    public class A implements Serializable {
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }
}
/*

public class Solution {

    public class A {
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }
}
*/

/*

public class Solution
{

    public static class A
    {
        String name = "A";

        public A()
        {
        }

        public A(String name)
        {
            this.name += name;
        }

        @Override
        public String toString()
        {
            return this.name;
        }
    }

    public static class B extends A
    {
        String name = "B";

        public B()
        {
        }

        public B(String name)
        {
            super(name);
            this.name += name;
        }

    }

    public static class C extends B implements Serializable
    {
        String name = "C";

        public C(String name)
        {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
//        A a = new A("-=this is A=-");
//        B b = new B("-=this is B=-");
//        C c = new C("-=this is C=-");
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
        C c2 = new C("c222");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:/77.txt"));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:/77.txt"));
        out.writeObject(c2);
        out.close();
        C c3 = new C("df");
    }
}

*/
