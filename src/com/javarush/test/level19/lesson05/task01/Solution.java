package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String pathFile1 = bufferedReader.readLine();
        String pathFile2 = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(pathFile1);
        FileWriter fileWriter = new FileWriter(pathFile2);
        int i = 1;
        while(fileReader.ready()) {
            int dataReader = fileReader.read();
            if (i%2 == 0) {
                fileWriter.write(dataReader);
            }
            i++;
        }
        fileReader.close();
        fileWriter.close();
    }
}
