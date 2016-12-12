package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class ExitCommand implements Command {
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Вы уверены, что хотите выйти?  <y,n>");
        if(ConsoleHelper.readString().equals("y")) {
            ConsoleHelper.writeMessage("Bay!");
        }
    }
}
