package com.javarush.test.level16.lesson13.home09;

/* Только по-очереди!
1. В классе Solution создать нить public static Read3Strings унаследовавшись от Thread.
2. В методе run реализовать чтение с консоли трех строк.
3. Три подряд введенных строки должны считываться в одной нити и объединяться в одну строку через пробел.
4. В методе main вывести результат для каждой нити.
5. Используйте join

Пример:
Входные данные
a
b
c
d
e
f
Выходные данные:
a b c
d e f
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println(t1.toString());
        System.out.println(t2);
    }
    public static class Read3Strings extends Thread {
        private List<String> list = new ArrayList<String>();
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    list.add(reader.readLine());
                }
            }
            catch (IOException e) {}
        }
        @Override
        public String toString() {
            String strTmp = "";
            for(String x:list) {
                strTmp = strTmp + x + " ";
            }
            return strTmp;
        }
    }
}
//==============Other method===============
/*

public static class Read3Strings extends Thread
{

    String userInput="";
    public void run()
    {
        try
        {

            for (int i = 0; i < 3; i++) {
                userInput = userInput + reader.readLine();
                if (i<2) {
                    userInput = userInput+" ";
                }

            }

        } catch (Exception e) {
        }

    }

    @Override
    public String toString()
    {
        return userInput;
    }
}
*/

//============================
/*

public class Solution
{
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException
    {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t2.start();
        System.out.println();
        System.out.println();
    }
}
*/
