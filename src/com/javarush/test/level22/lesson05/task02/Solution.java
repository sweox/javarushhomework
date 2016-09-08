package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String ret = "";
        if (string == null) {
            throw new TooShortStringException();
        }

        String strArr [] = string.split("\\t");

        if (strArr.length == 0) {
            System.out.println("");
        }
        else if (strArr.length == 1 || strArr.length == 2) {
            throw new TooShortStringException();
        }
        else  {
            ret = strArr[1];
        }

        return ret;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
/*

public class Solution {
    public static String getPartOfString(String string) {

        return null;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
*/
