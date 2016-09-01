package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.TreeMap;

public class Solution {
    public static String fileName;
    static TreeMap<Integer, String> map = new TreeMap<>();
    public static void main(String[] args) throws Exception {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();

        addProduct(removeZerroIndex(args));

    }

    public static void addProduct(String str[]) {
        char[] productName = str[0].toCharArray();
        char[] price = str[1].toCharArray();
        char[] quantity = str[2].toCharArray();
        try {
            writeToFile(addSpaceToEndArr(productName, 30), addSpaceToEndArr(price, 8),
                    addSpaceToEndArr(quantity, 4));
        }
        catch (IOException e) {}

    }

    public static String[] removeZerroIndex(String[] str) {
        String[] s = new String[str.length - 1];
        System.arraycopy(str, 1, s, 0, str.length - 1);
        return s;
    }

    public static char[] addSpaceToEndArr(char[] chars, int quantityIndex) {
        char[] ret = new char[quantityIndex];
        if (chars.length > quantityIndex) {
            System.arraycopy(chars, 0, ret, 0, quantityIndex);
        }
        else {
            System.arraycopy(chars, 0, ret, 0, chars.length);
            if (chars.length < quantityIndex) {
                for (int i = chars.length - 1; i < quantityIndex; i++) {
                    ret[i] = ' ';
                }
            }
        }
        return ret;
    }
    public static void writeToFile(char[] productName, char[] price, char[] quantity) throws IOException {
        String line = "";

        BufferedReader r = new BufferedReader(new FileReader(fileName));
        OutputStreamWriter w = new OutputStreamWriter(new FileOutputStream(fileName, true));
        if (!r.ready()) {
            w.write(addSpace(1, 8) + String.valueOf(productName) +
                    String.valueOf(price) + String.valueOf(quantity));
        }
        else
        {
            while (r.ready())
            {
                line = r.readLine();
                if (!line.isEmpty())
                {
                    map.put(stringToInt(line.substring(0, 8)), line.substring(8));
                }
            }
            r.close();


            w.write("\n" + addSpace(map.lastEntry().getKey() + 1, 8) +
                    String.valueOf(productName) +
                    String.valueOf(price) + String.valueOf(quantity));
        }

        w.close();
    }



    public static int stringToInt(String str) {
        String tmpStr = "";
        if (str.toCharArray()[str.length() - 1] != ' ') {
            tmpStr = str;
        }
        else {
            for(int i = 0; i < str.length(); i++) {
                if (str.toCharArray()[i] != ' ') {
                    tmpStr = str.substring(0, i + 1);
                }
            }
        }
        return Integer.parseInt(tmpStr);
    }
    public static String addSpace(Integer numb, Integer quant) {
        String str = String.valueOf(numb);
        if (str.length() < quant) {
            char[] chars = new char[quant];
            System.arraycopy(str.toCharArray(), 0, chars, 0, str.length());
            for (int i = str.length(); i < chars.length; i++) {
                chars[i] = ' ';
            }
            str = String.valueOf(chars);
        }
        if (str.toCharArray().length > quant) {
            str = String.valueOf(99999999);
        }
        return str;
    }
}
