package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream1;
        FileInputStream inputStream2;
        FileInputStream inputStream3;
        FileOutputStream outputStream;

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        inputStream1 = new FileInputStream(fileName1);
        inputStream2 = new FileInputStream(fileName2);
        inputStream3 = new FileInputStream(fileName3);

        outputStream = new FileOutputStream(fileName1);
        while(inputStream2.available() > 0) {
            byte[] dataByte = new byte[inputStream2.available()];
            int data = inputStream2.read(dataByte);
            outputStream.write(data);
        }
        while(inputStream1.available() > 0) {
            byte[] dataByte = new byte[inputStream1.available() + inputStream3.available()];
        }

    }
}
