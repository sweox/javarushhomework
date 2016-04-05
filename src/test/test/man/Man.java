package test.test.man;

/**
 * Created by BELSHINA on 06.04.2016.
 */
public class Man{
    int i = getInt();
    int k = 20;
    public int getInt() {  return k+1;  }
    public static void main(String[] args) {
        Man t = new Man();
        System.out.println(t.i + "  " + t.k);
    }
}