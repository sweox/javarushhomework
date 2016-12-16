package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static final ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
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
        ConsoleHelper.writeMessage(res.getString("choose.currency.code"));
        try {
            while((curCode = reader.readLine()).length() != 3) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
        catch (IOException e) {}
        return curCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] arrCurrency = null;
        ConsoleHelper.writeMessage(res.getString("choose.denomination.and.count.format"));

        while ((arrCurrency = readString().split(" ")).length != 2) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
        return arrCurrency;
    }

    public static Operation askOperation() throws InterruptOperationException {
        Operation operationReturn = null;
        while(true) {
            ConsoleHelper.writeMessage(res.getString("choose.operation"));
            ConsoleHelper.writeMessage("1 - " +res.getString("operation.INFO"));
            ConsoleHelper.writeMessage("2 - " +res.getString("operation.DEPOSIT"));
            ConsoleHelper.writeMessage("3 - " +res.getString("operation.WITHDRAW"));
            ConsoleHelper.writeMessage("4 - " +res.getString("operation.EXIT"));
            try {
                operationReturn = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
                break;
            }
            catch(IllegalArgumentException e) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
        return operationReturn;
    }

    public static void printExitMessage() {

        ConsoleHelper.writeMessage(res.getString("the.end"));
    }

}
