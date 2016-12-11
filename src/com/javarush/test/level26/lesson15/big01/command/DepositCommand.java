package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by BELSHINA on 10.12.2016.
 */
class DepositCommand implements Command {
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        //CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);

        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        String[] arrTwoDigits = ConsoleHelper.getValidTwoDigits(currencyCode);
        manipulator.addAmount(Integer.parseInt(arrTwoDigits[0]), Integer.parseInt(arrTwoDigits[1]));




    }
}
