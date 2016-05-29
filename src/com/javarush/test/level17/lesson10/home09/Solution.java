package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть
в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    static BufferedReader readerNameFile = new BufferedReader(new InputStreamReader(System.in));
    static BufferedReader readerFromFile1;
    static BufferedReader readerFromFile2;

    //static FileReader;
    public static void main(String[] args)  {
        try {

            readerFromFile1 = new BufferedReader(new FileReader(readerNameFile.readLine()));
            readerFromFile2 = new BufferedReader(new FileReader(readerNameFile.readLine()));

            writeToList(readerFromFile1, allLines);
            writeToList(readerFromFile2, forRemoveLines);

//            System.out.println(allLines);
//            System.out.println(forRemoveLines);

            readerNameFile.close();
            readerFromFile1.close();
            readerFromFile2.close();

            new Solution().joinData();

//            System.out.println(allLines);
//            System.out.println(forRemoveLines);
        }
        catch (Exception e) {
//            System.out.println("Попал!!!");
        }


    }

    public  void joinData () throws CorruptedDataException {
        System.out.println("Перед удалением");
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
//            System.out.println("Удаляю которые есть");
        }
        else {
                allLines.clear();
//            System.out.println("Очищаю список");
//            System.out.println(allLines);
//            System.out.println(forRemoveLines);
                throw new CorruptedDataException();
            }

    }
    public static void writeToList(BufferedReader reader, List list) throws IOException
    {
        String line;
        while((line = reader.readLine()) != null) {
            list.add(line);
        }
    }
}

/*

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
    }

    public void joinData () throws CorruptedDataException {

    }
}
*/
