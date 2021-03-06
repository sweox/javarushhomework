package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import java.util.Locale;

public class CashMachine {
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        Operation askOper;
        try {
            CommandExecutor.execute(Operation.LOGIN);
            do {
                askOper = ConsoleHelper.askOperation();
                CommandExecutor.execute(askOper);
            }
            while (askOper != Operation.EXIT);
        }
        catch (InterruptOperationException e) {
            try {
                CommandExecutor.execute(Operation.EXIT);
            }
            catch (InterruptOperationException e1) {
            }
            ConsoleHelper.printExitMessage();
        }
    }
}
