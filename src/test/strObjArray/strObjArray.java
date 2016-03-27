package test.strObjArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by BELSHINA on 27.03.2016.
 */
public class strObjArray
{
    public static void main(String[] args)
    {
        String[] strArr = {"Mike", "ggg"};
        Object[] objArr = strArr;
        //objArr[0] = new int[] {5, 5, 6};

        String value = strArr[0];
        System.out.println(value);
        System.out.println(Arrays.toString(strArr));

        ArrayList<? extends Number> ref = new ArrayList<Integer>();
        Number n = ref.get(0);
        Integer nn = null;
//        ref.add((Integer) nn);

        ArrayList<? extends Number> ref1 = null;
        ArrayList<? extends Integer> ref2 = null;
        ref1 = ref2;
//        ref2 = (ref1)ref1;
    }
}
