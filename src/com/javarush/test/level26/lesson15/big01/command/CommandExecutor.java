package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by BELSHINA on 10.12.2016.
 */
public class CommandExecutor {
    static Map<Operation, Command>  commandMap = new HashMap<>();
    private CommandExecutor() {}
    static {
        commandMap.put(Operation.INFO, new InfoCommand());
        commandMap.put(Operation.DEPOSIT, new DepositCommand());
        commandMap.put(Operation.WITHDRAW, new WithdrawCommand());
        commandMap.put(Operation.EXIT, new ExitCommand());
    }
    public static final void execute(Operation operation) {
        switch(operation) {
            case INFO:
                commandMap.get(Operation.INFO).execute();
                break;
            case DEPOSIT:
                commandMap.get(Operation.DEPOSIT).execute();
                break;
            case WITHDRAW:
                commandMap.get(Operation.WITHDRAW).execute();
                break;
            case EXIT:
                commandMap.get(Operation.EXIT).execute();
                break;
        }
    }
}
