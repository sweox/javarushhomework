package EkkelThinkingInJava.head02;

/**
 * Created by Belshina on 09.07.15.
 */
public class Head0201
{
    public int i;
    private char c;
    public int getI(){
        return i;
    }
    public char getC(){
        return c;
    }
    //Head0201 data = new Head0201();
    //data.i;
    public static void main(String[] args){
        Head0201 data = new Head0201();
        System.out.println(data.getI());
        System.out.println(data.c);
    }
}
