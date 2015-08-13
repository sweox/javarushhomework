package EkkelThinkingInJava.head03;

/**
 * Created by Admin on 13.08.2015.
 * Передача объектов методам может работать
 * не так, как вы привыкли
 */

    class Letter {
        char c;
    }
    public class Head0303 {
        static void f(Letter y){
            y.c = 'z';
        }
        public static void main(String[] args) {
            Letter x = new Letter();
            x.c = 'a';
            System.out.println("1: x.c: " + x.c);
            f(x);
            System.out.println("2: x.c: " + x.c);
        }
    }

