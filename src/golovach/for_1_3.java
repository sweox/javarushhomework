package golovach;

import java.util.Arrays;

/**
 * Created by ADMIN on 06.03.2015.
 */
public class for_1_3
{
    public static void main(String[] args)
    {
        testInvert(new int[] {});
        testInvert(new int[] {0});
        testInvert(new int[] {1, 2});
        testInvert(new int[] {0, 1, 2, 3, 4});
    }
    private static void testInvert(int[] arr)
    {

        System.out.print(Arrays.toString(arr) + "->");
        ArrayInverter.InvertRec(arr, 0);
        System.out.println(Arrays.toString(arr));
    }
}


