package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        //FileInputStream inputStreamFile1 = new FileInputStream(fileName1);
//        FileInputStream inputStreamFile2 = new FileInputStream(fileName2);
        FileOutputStream outputStream;

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        String bufStr = bufferedReader.readLine();
        bufferedReader.close();
        String[] strM = bufStr.split(" ");

        float[] floatM = new float[strM.length];
        for (int i = 0; i < strM.length; i++) {
            floatM[i] = Float.parseFloat(strM[i]);
        }
        int[] intM = new int[floatM.length];
        for(int i = 0; i < floatM.length; i++) {
            intM[i] = Math.round(floatM[i]);
        }
        byte[] byteM = new byte[intM.length];
        for(int i = 0; i < byteM.length; i++) {
            byteM[i] = (byte)intM[i];
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));
        for (int i = 0; i < intM.length; i++) {
            bufferedWriter.write((byte)6);
            if(intM[i] != intM.length - 1) {
                bufferedWriter.write(" ");
            }
        }
        bufferedWriter.close();
        //System.out.println(Arrays.toString(byteM));

    }
}
