package test.ReRef;

/**
 * Created by Belshina on 05.03.16.
 */
public  class ReRef {
//{
//    Dug d = new Dug();
//    public void go() {
//        d = new Dug();
//        d = null;
//        d.Method();
//    }
    public static class Dug {
        public void Method() {}
    }
    public static void main(String[] args)
    {
        Dug d = new Dug();

        d = new Dug();
        d = null;
        d.Method();
    }
}


