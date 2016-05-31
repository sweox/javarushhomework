package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream inputStreamFile1 = new FileInputStream(fileName1);
        FileInputStream inputStreamFile2 = new FileInputStream(fileName2);


        byte[] dataFile1 = new byte[inputStreamFile1.available()];
        inputStreamFile1.read(dataFile1);
        inputStreamFile1.close();

        byte[] dataFile2 = new byte[inputStreamFile2.available()];
        inputStreamFile2.read(dataFile2);
        inputStreamFile2.close();

        FileOutputStream outputStream = new FileOutputStream(fileName1);

        outputStream.write(dataFile2);
        outputStream.write(dataFile1);

        outputStream.close();

    }
}

/*
    Главное в этой задачке не открывать поток записи в файл, пока не закроешь поток чтения из того же файла.
*/

/*
public class Solution {
    public static void main(String[] args) throws IOException {
    }
}
*/
