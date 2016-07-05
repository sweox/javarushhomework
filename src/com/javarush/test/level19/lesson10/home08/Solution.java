package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readLine = new BufferedReader(new InputStreamReader(System.in));
        String pathFileName = readLine.readLine();
        readLine.close();
        BufferedReader readerFromFile = new BufferedReader(new FileReader(pathFileName));
        while(readerFromFile.ready()) {
            String str = readerFromFile.readLine();
            //revert(str);
            System.out.println(new String(revertRec(str.toCharArray(), 0)));
            //System.out.println(str);

        }
        readerFromFile.close();
    }

    public static void revert(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        System.out.println(stringBuilder.reverse());
    }

    public static char[] revertRec(char[] chArr, int off) {
        if(off < chArr.length/2)
        {
            char tmp = chArr[off];
            chArr[off] = chArr[chArr.length - 1 - off];
            chArr[chArr.length - 1 - off] = tmp;

            off++;
            revertRec(chArr, off);
        }
        //System.out.println(chArr);
        return chArr;
    }
}

/*

import java.io.*;

public class Solution {
    public static void main(String[] args) {

    }
}
*/
