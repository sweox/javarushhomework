package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.IOException;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    //static int countChar;
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(args[0]);
        ArrayList<Character> alphabet = new ArrayList<>();

        int countChar = 0;

        for(char j = 'A'; j <= 'Z'; j++) {
            alphabet.add(j);
        }
        for (char j = 'a'; j <= 'z'; j++) {
            alphabet.add(j);
        }


        while(inputStream.available()>0) {
            if (alphabet.contains((char)inputStream.read()))
                countChar = countChar + 1;
        }
        inputStream.close();
        System.out.println(countChar);
    }
}

/*

public class Solution {
    //static int countChar;
    public static void main(String[] args) throws IOException {
    }
}
*/
