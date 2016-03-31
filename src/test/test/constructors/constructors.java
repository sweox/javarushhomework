package test.test.constructors;

/**
 * Created by BELSHINA on 31.03.2016.
 */
public class constructors
{
    public class A {
        A() {}
        A(int i, String s) {

        }
    }
    public class B extends A {
        B() {
            super();
        }
    }
    public class C extends B{

    }
}
