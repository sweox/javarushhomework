package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by BELSHINA on 10.12.2016.
 */
class ExitCommand implements Command {
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Вы уверены, что хотите выйти?  <y,n>");
        if(ConsoleHelper.readString().equals("y")) {
            ConsoleHelper.writeMessage("Bay!");
        }
    }
}
