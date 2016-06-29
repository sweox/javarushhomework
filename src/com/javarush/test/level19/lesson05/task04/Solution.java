package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
        String patchFileName1 = bufferedReader.readLine();
        String patchFileName2 = bufferedReader.readLine();
        inputStream.close();
        inputStreamReader.close();
        bufferedReader.close();
        FileReader readerData = new FileReader(patchFileName1);
        FileWriter fileWriter = new FileWriter(patchFileName2);
        while(readerData.ready()) {
            int readData = readerData.read();
            if(readData == '.')
                fileWriter.write('!');
            else
                fileWriter.write(readData);
        }
        readerData.close();
        fileWriter.close();
    }
}

/*

public class Solution {
    public static void main(String[] args) throws IOException {
    }
}
*/
