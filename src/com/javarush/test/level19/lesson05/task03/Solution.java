package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameForInputReader = bufferedReader.readLine();
        String fileNameForOutputStream = bufferedReader.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileNameForInputReader));
        FileWriter fileWriter = new FileWriter(fileNameForOutputStream);
        while(reader.ready()) {
            String [] mas = reader.readLine().split(" ");
            for(String strMass : mas) {
                if(Character.isDigit(strMass.charAt(0))
                        && Character.isDigit(strMass.charAt(strMass.length() - 1))) {
                    fileWriter.write(Integer.parseInt(strMass) + " ");
                }
            }
        }
        bufferedReader.close();
        reader.close();
        fileWriter.close();
    }
}
