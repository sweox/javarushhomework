package test.test;

/**
 * Created by Admin on 13.03.2016.
 */
public class Clss
{
    public static class One {
        static int i;
        public int h;
        String str = "jj";
        public static void setOne(int i) {
            One o = new One();
            o.Incr(i);
        }
        public String getOne() {
            return str;
        }
        public int Incr(int j) {
            return j++;
        }
    }

    public static class Twu {
        int g;
    }

    public static void main(String[] args)
    {
        One one = new One();
        Twu twu = new Twu();
        one.Incr(twu.g);
        One.setOne(twu.g);
        one.setOne(twu.g);
    }
}
