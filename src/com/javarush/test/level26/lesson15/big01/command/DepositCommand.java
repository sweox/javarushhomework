package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.deposit_en");

    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();

        try {
            String[] arrTwoDigits = ConsoleHelper.getValidTwoDigits(currencyCode);
            CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
            manipulator.addAmount(Integer.parseInt(arrTwoDigits[0]), Integer.parseInt(arrTwoDigits[1]));

            ConsoleHelper.writeMessage(String.format(res.getString("success.format"),
                    manipulator.getTotalAmount(),
                    currencyCode));

        }
        catch (InterruptOperationException e) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }








    }
}
