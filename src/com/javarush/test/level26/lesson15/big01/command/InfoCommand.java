package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Collection;
import java.util.ResourceBundle;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.info_en");
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        Collection<CurrencyManipulator> collection = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if(collection.size() == 0 || collection.isEmpty())
            ConsoleHelper.writeMessage(res.getString("no.money"));
        for(CurrencyManipulator c:collection) {
            if(c.hasMoney()) {
                ConsoleHelper.writeMessage(c.getCurrencyCode() + " - " + c.getTotalAmount());
            }
            else
                ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
