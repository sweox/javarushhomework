package test.test.pair;

/**
 * Created by BELSHINA on 30.03.2016.
 */
public class Pair
{
    public static void main(String[] args)
    {
        Pair2<String, Integer> n = new Pair2<String, Integer>("Vova", 34);
        System.out.println(n.fst);
        System.out.println(n.snd);
//        Pair2<String, Pair2<String, Pair2<Integer, Integer>>> quadro =
//                new Pair2<String, Pair2<String, Pair2<Integer, Integer>>>();
        Pair2<Pair2<Pair2<String, String>, Integer>, Integer> quadro2;

    }
    public static class Pair2<A, B> {
        public final A fst;
        public final B snd;
        Pair2(A fst, B snd) {
            this.fst = fst;
            this.snd = snd;
        }
//        public String toString() {
//
//            return null;
//        }
    }
}
