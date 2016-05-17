package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
        FileInputStream inputStreamFile1 = new FileInputStream(reader.readLine());
        FileOutputStream outputStreamFile2 = new FileOutputStream(reader.readLine());
        FileOutputStream outputStreamFile3 = new FileOutputStream(reader.readLine());

        if (inputStreamFile1.available() > 0) {
            byte[] data = new byte[inputStreamFile1.available()];
            int count = inputStreamFile1.read(data);
            outputStreamFile2.write(data, 0, (count/2 + count%2));
            outputStreamFile3.write(data, (data.length/2 + data.length%2), count/2);
        }
        reader.close();
        inputStreamFile1.close();
        outputStreamFile2.close();
        outputStreamFile3.close();
    }
}

/*

public class Solution {
    public static void main(String[] args) throws IOException {

    }
}
*/
