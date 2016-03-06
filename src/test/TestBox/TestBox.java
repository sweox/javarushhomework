package test.TestBox;

/**
 * Created by Admin on 06.03.2016.
 */
public class TestBox
{
    Integer i;
    int j;

    public static void main(String[] args)
    {
        TestBox t = new TestBox();
        t.go();
    }
    public void go() {
        j = i;
        System.out.println(j);
        System.out.println(j);
    }
}
