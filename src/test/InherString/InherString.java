package test.InherString;

/**
 * Created by Belshina on 05.03.16.
 */
public class InherString
{
    public class Parent {
        public String par;
        public Parent(String s) {
            super();
            par = s;
        }
    }
    public class Son extends Parent {
        public Son() {
            super("f");
        }
    }

    public static void main(String[] args)
    {
//        Son d = new Son();
//        d.par:
    }

}
