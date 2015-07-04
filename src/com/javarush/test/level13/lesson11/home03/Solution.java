package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.InputStream;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();

        InputStream input = new FileInputStream(path);
        ArrayList<Integer> listInteger = new ArrayList<Integer>();
        //ArrayList<String> listString = new ArrayList<String>();
        //FileOutputStream output = new FileOutputStream();

        //for (char c='а'; c<='я'; c++) {
        //    System.out.println("code="+(int)c+"\tsumbol="+c);
        //}

        while (input.available() > 0)
        {
            int data = input.read();
            listInteger.add(data);
            //System.out.print((char)input.read());
        }
        //for (int f:listInteger)
        //{
        //    String str = Integer.toString(f);
        //    listString.add(str);
        //}
        input.close();
        System.out.println(listInteger);
    }
}
