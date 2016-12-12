package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Collection;

class InfoCommand implements Command {
    public void execute() throws InterruptOperationException {
        Collection<CurrencyManipulator> collection = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if(collection.size() == 0 || collection.isEmpty())
            ConsoleHelper.writeMessage("No money available.");
        for(CurrencyManipulator c:collection) {
            if(c.hasMoney()) {
                ConsoleHelper.writeMessage(c.getCurrencyCode() + " - " + c.getTotalAmount());
            }
            else
                ConsoleHelper.writeMessage("No money available.");
        }
    }
}
