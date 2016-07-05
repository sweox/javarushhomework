package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String patchFileName1 = reader.readLine();
        String patchFileName2 = reader.readLine();
        BufferedReader readerFile1 = new BufferedReader(new FileReader(patchFileName1));
        FileWriter writerFile2 = new FileWriter(patchFileName2);

        while(readerFile1.ready()) {
            String [] strArr = readerFile1.readLine().split(" ");
            String line = "";
            for(String c : strArr) {
                if(c.toCharArray().length > 6) {

                    if(line.equals(""))
                        line = line + c;
                    line = line + "," + c;
                }
            }
            writerFile2.write(line, 0, line.length());
        }
        reader.close();
        readerFile1.close();
        writerFile2.close();


    }
}
