package com.javarush.test.level14.lesson08.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
//=============1-й вариант===================
        /*int min = 0;
        min = (a < b) ? a : b;
        int delitel = 1;
        for (int i = 1; i <= min; i++) {
            if (a%i==0 && b%i==0) {
                delitel  = i;
            }
        }
        System.out.println(delitel);*/
//============2-й вариант==================
        numbers(a, list1);
        numbers(b, list2);
        delitel(list1, list2, list3);
        //System.out.println(list1);
        //System.out.println(list2);
        //System.out.println(list3);
        System.out.println(list3.get(list3.size() - 1));

    }
    public static void numbers(int number, ArrayList<Integer> list) {
        for (int i = 1; i <= number; i++) {
            if (number%i==0) {
                list.add(i);
            }
        }
    }

    public static void delitel(ArrayList<Integer> list1, ArrayList<Integer> list2,
                              ArrayList<Integer> list3) {
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i)==list2.get(j)) {
                    list3.add(list1.get(i));
                }
            }
        }
    }

}

/*
public class Solution
{
    public static void main(String[] args) throws Exception
    {
    }
}
*/
