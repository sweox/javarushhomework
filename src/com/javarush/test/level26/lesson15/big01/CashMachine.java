package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Arrays;
import java.util.Locale;

/**
 * Created by Admin on 08.12.2016.
 */
public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
//        String currencyCod = ConsoleHelper.askCurrencyCode();
//        String[] twoIntFromConsole = ConsoleHelper.getValidTwoDigits(currencyCod);
//        CurrencyManipulator currencyManipulator = new CurrencyManipulator(currencyCod);
//        currencyManipulator.addAmount(Integer.parseInt(twoIntFromConsole[0]), Integer.parseInt(twoIntFromConsole[1]));
//        System.out.println(currencyManipulator.getTotalAmount());
        //System.out.println(Operation.getAllowableOperationByOrdinal(4));

        //System.out.println(ConsoleHelper.askOperation());
        Operation askOper;
        try {
            do {
                askOper = ConsoleHelper.askOperation();
                CommandExecutor.execute(askOper);
            }
            while (askOper != Operation.EXIT);
        }
        catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage("До свидания!");
        }
    }
}
