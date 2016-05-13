package test.test.Point2D;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Admin on 13.05.2016.
 */
public class Point2D
{
    public static void main(String[] args)
    {
        List<Poin> poin1 = new ArrayList<Poin>();
        poin1.add(new Poin(0, 10));
        poin1.add(new Poin(0, 10));
        poin1.add(new Poin(0, 5));
        System.out.println(poin1.toString());
        System.out.println(poin1.contains(new Poin(0, 5)));
    }
    public static class Poin {
        int x;
        int y;
        public Poin(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public String toString() {
            return x + " " + y;
        }
        public boolean equals(Object obj) {
            Poin ob = (Poin)obj;
            if (this.x == ob.x && this.y == ob.y)
                return true;
            else
                return false;
        }
    }
}
