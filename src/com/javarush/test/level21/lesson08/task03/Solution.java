package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
        public Object clone() throws CloneNotSupportedException
        {
            return super.clone();
        }
    }

    public static class B extends A  {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public Object clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B  {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        public Object clone() throws CloneNotSupportedException {
            return new C(getI(), getJ(), getName());
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException
    {
        A a = new A(3, 4);
        B b = new B(5, 6, "B");
        C c = new C(7, 8, "C");
        System.out.println(a);
        System.out.println(b);
        B b1 = (B) b.clone();
        C c1 = (C)c.clone();
        System.out.println("clone C : " + c1.getI() + " " + c1.getJ() + " " + c1.getName());
        System.out.println("clone B : " + b1.getI() + " " + b1.getJ() + " " + b1.getName());
    }
}


/*

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }
    }
}
*/
