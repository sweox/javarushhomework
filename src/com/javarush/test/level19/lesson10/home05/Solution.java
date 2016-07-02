package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException
    {

/*
        FileWriter fileWriter = new FileWriter(args[0]);
        BufferedReader bufferFileReadLine = new BufferedReader(new FileReader(args[1]));
        String line;
        String[] exnum = {"1","2","3","4","5","6","7","8","9","0"};

        while ((line = bufferFileReadLine.readLine())!=null){
            String[] buff = line.split(" ");
            for (String a : buff){
                for ( String b : exnum){
                    if (a.contains(b))
                        fileWriter.write(a+" ");
                }
            }
        }
        bufferFileReadLine.close();
        fileWriter.close();
*/

        BufferedReader readerFromFile1 = new BufferedReader(new FileReader(args[0]));
        FileWriter writeToFile = new FileWriter(args[1]);
        while(readerFromFile1.ready()) {
            String[] strArr = readerFromFile1.readLine().split(" ");
            for(String s : strArr) {
                if(worldIsDigit(s)) {
                    writeToFile.write(s + " ");
                }
            }
        }
        readerFromFile1.close();
        //writeToFile.flush();
        writeToFile.close();

    }

    public static boolean worldIsDigit(String str) {
        boolean token = false;
        boolean digit = false;
        boolean ret = false;

        for(char c : str.toCharArray()) {
            if(Character.isDigit(c))
                digit = true;
            else
                token = true;
        }
        if(token && digit)
            ret = true;
        return ret;
    }
}
/*

public class Solution {
    public static void main(String[] args) {
    }
}
*/
