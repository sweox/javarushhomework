package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String r = reader.readLine();
        ArrayList<Integer> list = new ArrayList<Integer>();
        OutputStream output = new FileOutputStream(r);
        while (!reader.readLine().equals("exit")){
            list.add(Integer.parseInt(reader.readLine()));
        }
        while(list.size() > 0){
            for (int x:list){
                output.write(x);
            }
            //output.write(list);
        }

        reader.close();
        //input.close();
        output.close();
    }
}
