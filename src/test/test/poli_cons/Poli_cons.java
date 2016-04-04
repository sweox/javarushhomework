package test.test.poli_cons;

/**
 * Created by BELSHINA on 05.04.2016.
 */
public class Poli_cons
{
    class A {
        String str = "ab";
        A() {
            printLength();
        }
        void printLength() {
            System.out.println(str.length());
        }
    }
    class B extends A {
        String str = "abc";
        void printLength() {
            System.out.println(str.length());
        }
    }

    public static void main(String[] args)
    {
        new Poli_cons().new B();
    }
}
