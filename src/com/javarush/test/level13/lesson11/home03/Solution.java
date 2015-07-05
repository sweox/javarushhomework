package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/
/**
 * http://www.skipy.ru/technics/encodings.html     Про кодировки
 * http://www.mkyong.com/java/how-to-read-utf-8-encoded-data-from-a-file-java/      UTF-8
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class Solution
{
    public static void main(String[] args) throws IOException, FileNotFoundException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();

        InputStream input = new FileInputStream(path);
        //OutputStream output = new PrintStream (System.out);
        //ArrayList<Integer> listInteger = new ArrayList<Integer>();
        //FileOutputStream output = new FileOutputStream();

        //for (char c='а'; c<='я'; c++) {
        //    System.out.println("code="+(int)c+"\tsumbol="+c);
        //}

        while (input.available() > 0)
        {
            //int data = input.read();
            //listInteger.add(data);
            System.out.print((char)(input.read()));
        }
        input.close();
        reader.close();
    }
}

/**
public class Solution
{
    public static void main(String[] args) throws IOException,FileNotFoundException
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String s=reader.readLine();

        InputStream inStream = new FileInputStream(s);
        //add your code here

        while (inStream.available()>0){
            int data =inStream.read();
            System.out.print((char)data);
        }
        inStream.close();
    }

}
*/