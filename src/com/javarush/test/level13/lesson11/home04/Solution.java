package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/
/**
 * Для справки:
 *Writer/*Reader классы предназначены для работы с символьными потоками,
 * а *Stream - с байтовыми
 * http://citforum.ru/internet/javascript/java_rbint.shtml
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
        OutputStream output = new FileOutputStream(r);
        while (true)
        {
            String g = reader.readLine();
            if (g.equals("exit"))
            {
                output.write((g + "\n").getBytes());
                break;
            }
            else
                output.write((g + "\n").getBytes());

        }
        reader.close();
        output.close();
    }
}
/**
String line;
while (!(line = reader.readLine()).equals("exit")) {
        line += "\r\n";
        out.write(line.getBytes());
        }
 */