package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;

class WithdrawCommand implements Command {
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator =
                CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String str;
        int sum = 0;
        while(true) {
            str = ConsoleHelper.readString();
            try{
                sum = Integer.parseInt(str);
            }
            catch (NumberFormatException e) {
                ConsoleHelper.writeMessage("Неверно введены данные ParseInt");
                continue;
            }
            if(sum < 0 ) {
                ConsoleHelper.writeMessage("Неверно введены данные <0");
                continue;
            }

            if(!currencyManipulator.isAmountAvailable(sum)) {
                ConsoleHelper.writeMessage("Недостаточно средств");
                continue;
            }
            try {
                currencyManipulator.withdrawAmount(sum);
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage("Не хватает банкнот");
                continue;
            }

            ConsoleHelper.writeMessage("Поздравляем");
            break;
        }
    }
}
