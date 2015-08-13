package EkkelThinkingInJava.head03;

/**
 * Created by Admin on 13.08.2015.
 * Присваивание объекта имеет ряд хитростей
 */


    class Tank{
        float level;
    }
    public class Head0302{
        public static void main(String[] args) {
            Tank t1 = new Tank();
            Tank t2 = new Tank();
            t1.level = 9;
            t2.level = 47;
            System.out.println("1: t1.level: " + t1.level + ", t2.level: " + t2.level);
            t1 = t2;
            //t1.level = t2.level;
            System.out.println("2: t1.level: " + t1.level + ", t2.level: " + t2.level);
            t1.level = 27;
            System.out.println("3: t1.level: " + t1.level + ", t2.level: " + t2.level);
        }
    }

