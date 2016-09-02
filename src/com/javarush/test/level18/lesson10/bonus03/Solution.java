package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    static BufferedReader reader;
    static BufferedWriter writer;
    static String fileName;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName = reader.readLine();


        String id = args[1];
        String productName = args[2];
        String price = args[3];
        String quantity = args[4];
        switch(args[0]) {
            case "-u" : update( id,  productName,  price,  quantity,  fileName); break;
            case "-d" : logDelete(id, " ", " ", " ", fileName); break;
        }
        }
        catch (IOException e) {}
    }
    static void update (String id, String productName, String price, String quantity, String fileName) throws  IOException{
        if (checkReady(fileName)) {
            readFileForUpdate(id, productName, price, quantity, fileName);
            fileWrite(list, fileName);
        }

    }

    static void logDelete(String id, String productName, String price, String quantity, String fileName) throws  IOException {
        if (checkReady(fileName)) {
            readFileForDelete(id, productName, price, quantity, fileName);
            fileWrite(list, fileName);
        }
    }

    static void readFileForUpdate(String id, String productName, String price, String quantity, String fileName) throws IOException {

        String line = "";
        BufferedReader read = new BufferedReader(new FileReader(fileName));
        while (read.ready())
        {
            line = read.readLine();
            if (!line.isEmpty())
            {
                if (checkId(id) == checkId(line.substring(0, 8)))
                {
                    list.add(parseStr(String.valueOf(id), 8) + parseStr(productName, 30) + parseStr(price, 8) + parseStr(quantity, 4));
                }
                else
                {
                    list.add(line);
                }
            }
            else
            {
                list.add(line);
            }
        }
        read.close();


    }

    static void readFileForDelete(String id, String productName, String price, String quantity, String fileName) throws IOException {

        String line = "";
        BufferedReader read = new BufferedReader(new FileReader(fileName));
        while (read.ready())
        {
            line = read.readLine();
            if (!line.isEmpty())
            {
                if (checkId(id) == checkId(line.substring(0, 8)))
                {
                    list.add(parseStr(String.valueOf(id), 8) + parseStr(productName, 30) + parseStr(price, 8) + parseStr(quantity, 4));
                }
                else
                {
                    list.add(line);
                }
            }
            else
            {
                list.add(line);
            }
        }
        read.close();


    }

    static void fileWrite(ArrayList<String> list, String fileName) throws IOException {
        BufferedWriter wr = new BufferedWriter(new FileWriter(fileName));
        for(String s : list) {
            wr.newLine();
            wr.write(s);
        }
        wr.close();
    }
    static String parseStr(String str, int length) {
        String tmp = "";
        if (str.length() == length) {
            tmp = str;
        }
        if (str.length() > length) {
            tmp = str.substring(0, length);
        }
        if (str.length() < length) {
            while (str.length() != length) {
                str = str.concat(" ");
            }
            tmp = str;
        }
        return tmp;
    }
    static Boolean checkReady(String fileName) throws IOException {
        boolean tmp = false;
        BufferedReader readFile = new BufferedReader(new FileReader(fileName));
        if (readFile.ready()) {
            tmp = true;
        }
        readFile.close();
        return tmp;
    }
    static int checkId(String str) {
        return Integer.parseInt(str.trim());
    }
}
