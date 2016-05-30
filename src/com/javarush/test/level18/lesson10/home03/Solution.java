package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        String file3 = br.readLine();
        br.close();

        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        FileInputStream fileInputStream2 = new FileInputStream(file2);
        FileInputStream fileInputStream3 = new FileInputStream(file3);

        byte[] buffer2 = new byte[fileInputStream2.available()];
        fileInputStream2.read(buffer2);
        fileInputStream2.close();

        byte[] buffer3 = new byte[fileInputStream3.available()];
        fileInputStream3.read(buffer3);

        fileOutputStream.write(buffer2);
        fileOutputStream.write(buffer3);

        fileOutputStream.close();
        fileInputStream2.close();
        fileInputStream3.close();


    }
}
//Мой вариант почему-то не работал!!!!
/*
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream2;
        FileInputStream inputStream3;
        FileOutputStream outputStream;

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        inputStream2 = new FileInputStream(fileName2);
        inputStream3 = new FileInputStream(fileName3);
        outputStream = new FileOutputStream(fileName1);


        byte[] dataByte2 = new byte[inputStream2.available()];
        int count2 = inputStream2.read(dataByte2);
        outputStream.write(dataByte2, 0, count2);



        byte[] dataByte3 = new byte[inputStream3.available()];
        int count3 = inputStream3.read(dataByte3);
        outputStream.write(dataByte3, 0, count3);

        reader.close();
        inputStream2.close();
        inputStream3.close();
        outputStream.close();

    }
}
*/
