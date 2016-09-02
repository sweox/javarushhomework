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
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        /*Считывание с консоли имя файла для операции*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        String stringWrite = "";

        if (!args[0].equals("-d"))
        {
         /*Подготовка ID для записи в файл*/
            String idString = args[1];
            for (int i = idString.length(); i < 8; i++)
            {
                idString += " ";
            }

        /*Получение кол-ва элементов с которых состоит productName, порядок сдвига для остальных элементов*/
            int dif = args.length - 5;

        /*Подготовка productName для записи в файл*/
            String productName = "";
            for (int i = 2; i <= (2 + dif); i++)
            {
                productName += args[i] + " ";
            }
            if (productName.length() > 30)
            {
                productName = productName.substring(0, 30);
            } else
            {
                for (int i = productName.length(); i < 30; i++)
                {
                    productName += " ";
                }
            }
        /*Подготовка price для записи в файл*/
            String price = Double.parseDouble(args[3 + dif]) + "";
            for (int i = price.length(); i < 8; i++)
            {
                price += " ";
            }
        /*Подготовка quantity для записи в файл*/
            String quantity = args[4 + dif];
            for (int i = quantity.length(); i < 4; i++)
            {
                quantity += " ";
            }
            stringWrite = idString + productName + price + quantity; //Строка для записи
        }

        LinkedList<String> listOfStrings = new LinkedList<String>(); //Тут хранить считаные строки

        /*Считывание файла fileName, логика заполнения listOfStrings*/
        Scanner inputSream = new Scanner(new File(fileName));
        while (inputSream.hasNext()){
            String tmp = inputSream.nextLine();
            String tmpId = tmp.substring(0, 8).trim();
            if (tmpId.equals(args[1])){
                if (args[0].equals("-u")){
                    listOfStrings.add(stringWrite);
                } else {
                    continue;
                }
            } else {
                listOfStrings.add(tmp);
            }
        }

        /*Перезапись выходного файла, согласно проведенных манипуляций*/
        FileOutputStream outputStream = new FileOutputStream(fileName, false);
        for (String tmp : listOfStrings){
            outputStream.write((tmp + "\r\n").getBytes());
        }
        outputStream.close();
    }
}


/*
public class Solution {
    public static void main(String[] args) {

    }
}*/

//----------Почему-то моя не проходила------------

/*

import java.io.*;
        import java.util.ArrayList;

public class Solution {
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();

            switch(args[0]) {
                case "-u" : update( args, fileName); break;
                case "-d" : logDelete(args, fileName); break;
            }
        }
        catch (IOException e) {}
    }
    static void update (String[] args, String fileName) throws  IOException{
        String id = args[1];
        String productName = args[2];
        String price = args[3];
        String quantity = args[4];

        readFileForUpdate(id, productName, price, quantity, fileName);
        fileWrite(list, fileName);


    }

    static void logDelete(String[] args, String fileName) throws  IOException {
        String id = args[1];

        readFileForDelete(id, fileName);
        fileWrite(list, fileName);

    }

    static void readFileForUpdate(String id, String productName, String price, String quantity, String fileName)
            throws IOException {

        String line = "";
        BufferedReader read = new BufferedReader(new FileReader(fileName));
        while (read.ready()) {
            line = read.readLine();

            if (checkId(id) == checkId(line.substring(0, 8))) {
                list.add(parseStr(String.valueOf(id), 8) + parseStr(productName, 30) + parseStr(price, 8) +
                        parseStr(quantity, 4));
            }
            else {
                list.add(line);
            }


        }
        read.close();


    }

    static void readFileForDelete(String id, String fileName) throws IOException {

        String line = "";
        BufferedReader read = new BufferedReader(new FileReader(fileName));
        while (read.ready()) {
            line = read.readLine();

            if (checkId(id) != checkId(line.substring(0, 8))) {
                list.add(line);
            }

        }
        read.close();
    }

    static void fileWrite(ArrayList<String> list, String fileName) throws IOException {
        BufferedWriter wr = new BufferedWriter(new FileWriter(fileName));
        for(String s : list) {
            wr.write(s);
            wr.newLine();
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

    static int checkId(String str) {
        return Integer.parseInt(str.trim());
    }
}
*/
