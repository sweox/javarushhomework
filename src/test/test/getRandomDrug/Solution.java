package test.test.getRandomDrug;

import com.javarush.test.level17.lesson10.home03.Drug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Belshina on 14.03.16.
 */
public class Solution
{
    public static Map<Drug, Integer> allDrugs = new HashMap<Drug, Integer>();   // <Лекарство, Количество>

    static {
        Drug panadol = new Drug();
        panadol.setName("Панадол");
        allDrugs.put(panadol, 5);

        Drug analgin = new Drug();
        analgin.setName("Анальгин");
        allDrugs.put(analgin, 18);

        Drug placebo = new Drug();
        placebo.setName("Плацебо");
        allDrugs.put(placebo, 1);
    }

        static  double index = Math.random() * 1000;
        //static int index1 = (int) (index);
        static double size = allDrugs.size();
        static double index2 = index % size;
        static double i = 65.3535945426077 % 3.0;
        static double i1 = 889 % 12;
        static double i2 = (Math.random() * 3) + 1;



//    public static Drug getRandomDrug() {
//        int index = (int) ((Math.random() * 1000) % (drugsController.allDrugs.size()));
//        List<Drug> drugs = new ArrayList<Drug>(drugsController.allDrugs.keySet());
//        return drugs.get(index);
//    }

    public static void main(String[] args)
    {
        System.out.println("index - " + index);
        //System.out.println("index1 - " + index1);
        System.out.println("size - " + size);
        System.out.println("index2 - " + index2);
        System.out.println("i - " + i);
        System.out.println("i1 - " + i1);
        System.out.println("i2 - " + i2);
    }
}
