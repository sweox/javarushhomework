package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() throws InterruptOperationException {
        String strReturn = "";
        try {
            strReturn = reader.readLine();
            if(strReturn.equalsIgnoreCase("exit"))
                throw new InterruptOperationException();
        }
        catch (IOException e) {
            //throw new InterruptOperationException();
        }
        return strReturn;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
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

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] arrCurrency = null;
        System.out.println("Введите два целых положительных числа.\n" +
                "Первое число - номинал, второе - количество банкнот");

        while ((arrCurrency = readString().split(" ")).length != 2) {
            System.out.println("Неверно введены данные");
        }
        return arrCurrency;
    }

    public static Operation askOperation() throws InterruptOperationException {
        Operation operationReturn = null;
        while(true) {
            System.out.println("Выберите операцию: 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
            try {
                operationReturn = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
                break;
            }
            catch(IllegalArgumentException e) {System.out.println("Неверно введены данные");}
        }
        return operationReturn;
    }

}
