package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Admin on 08.12.2016.
 */
public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() {
        String strReturn = "";
        try {
            strReturn = reader.readLine();
        }
        catch (IOException e) {}
        return strReturn;
    }

    public static String askCurrencyCode() {
        String curCode = "";
        System.out.println("Введите код валюты");
        try {
            while((curCode = reader.readLine()).length() != 3) {
                System.out.println("Неверно введены данные");
            }
        }
        catch (IOException e) {}
        return curCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        String[] arrCurrency = null;
        System.out.println("Введите два целых положительных числа.\n" +
                "Первое число - номинал, второе - количество банкнот");
        try {
            while ((arrCurrency = reader.readLine().split(" ")).length != 2) {
                System.out.println("Неверно введены данные");
            }
        }
        catch(IOException e) {}
        return arrCurrency;
    }

}
