package EkkelThinkingInJava.head02;

/**
 * Created by Belshina on 09.07.15.
 */
public class Head0205
{
    static class DataOnly{
        int i = 54;
        double d = 0.56;
        boolean b = true;
    }
    public static void main(String[] args){
        DataOnly data = new DataOnly();
        System.out.println(new DataOnly().i + " " + data.d + " " + data.b);
    }
}
