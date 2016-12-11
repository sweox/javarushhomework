package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;

/**
 * Created by BELSHINA on 10.12.2016.
 */
class InfoCommand implements Command {
    public void execute() {
        Collection<CurrencyManipulator> collection = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        for(CurrencyManipulator c:collection) {
            if(c.getTotalAmount() == 0) {
                ConsoleHelper.writeMessage("No money available.");
            }
            else
                ConsoleHelper.writeMessage(c.getCurrencyCode() + " - " + c.getTotalAmount());
        }
    }
}
