package eckel;

/**
 * Created by Admin on 06.07.2015.
 */
public class test
{
    public static void main(String[] arg){
        DataOnly data = new DataOnly();
        System.out.println(data.i + " " + data.b + " " + data.d);
        data.i = 47;
        DataOnly.b = true;
        System.out.println(data.i + " " + data.b + " " + data.d);

        DataOnly n = new New();
        n.i = 55;
    }

}
class DataOnly{
    public int i;
    public double d;
    public static boolean b;
}
class New extends DataOnly {}