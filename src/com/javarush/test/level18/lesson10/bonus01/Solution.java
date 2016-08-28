package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    static FileInputStream inputStream;
    static FileOutputStream outputStream;

    public static void main(String[] args) {
        //String[] s = {"-e", "c:/c.txt", "c:/d.txt"};
        //String[] s = {"-d", "c:/d.txt", "c:/e.txt"};
        //args = s;
        try {
            switch (args[0]) {
                case "-e":
                    code(args[1], args[2]);
                    break;
                case "-d":
                    deCode(args[1], args[2]);
            }
        }
        catch(IOException e) {}
    }
    static void code(String fileName, String fileOutputName) throws IOException
    {
        inputStream = new FileInputStream(fileName);
        outputStream = new FileOutputStream(fileOutputName);
        while(inputStream.available() > 0) {
            int tmp = inputStream.read() + 1;
            outputStream.write(tmp);
        }
        inputStream.close();
        outputStream.close();
    }
    static void deCode(String fileName, String fileOutputName) throws IOException
    {
        inputStream = new FileInputStream(fileName);
        outputStream = new FileOutputStream(fileOutputName);
        while (inputStream.available() > 0) {
            int tmp = inputStream.read() - 1;
            outputStream.write(tmp);
        }
        inputStream.close();
        outputStream.close();
    }

}


/*
public class Solution {
    public static void main(String[] args) {

    }
}
*/
