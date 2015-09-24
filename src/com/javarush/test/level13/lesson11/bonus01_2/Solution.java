package com.javarush.test.level13.lesson11.bonus01_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream inputStream = new FileInputStream(reader.readLine());
        String data = ""; char ch; int c = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (inputStream.available() > 0) {
            ch = (char) c;
            c = inputStream.read();
            if (Character.isDigit((char)c))
                if (ch =='-') {
                    data += String.valueOf(ch);
                    data += String.valueOf((char)c);
                }
                else
                    data += String.valueOf((char)c);
            else {
                if (data.isEmpty())
                    continue;
                int n = Integer.parseInt(data);
                if (n % 2 == 0)
                    list.add(n);
                data = "";
            }

        }

        inputStream.close();// напишите тут ваш код

        Collections.sort(list);
        for (int i : list)
            System.out.println(i);
    }
}

/*
у твоем цикле data записывается в момент 1 захода, а обрабатывается только если isDigit дает false. поэтому в последней
итерации дата изменяется, но не обрабатывается.

PS.Есть решение проще, если использовать для чтения из файла Scanner. у Scannera есть метод nextInt().
//-----------------------
Спасибо. Не заметил, что последний раз else не выполнится. А Scanner я еще не использовал. Надо порозбираться с этим классом.
 */