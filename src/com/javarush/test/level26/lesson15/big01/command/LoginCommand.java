package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;


/**
 * Created by BELSHINA on 13.12.2016.
 */
public class LoginCommand implements Command {
    private String cardNumber = "123456789012";
    private String pinCode = "1234";
    public void execute() throws InterruptOperationException {
        String cardNumberReader;
        String pinCodeReader = "";
        while(true) {
            ConsoleHelper.writeMessage("Введите номер кредитной карты");
            cardNumberReader = ConsoleHelper.readString();
            ConsoleHelper.writeMessage("Введите PIN-код");
            pinCodeReader = ConsoleHelper.readString();
            if(cardNumberReader.equals(cardNumber) && pinCodeReader.equals(pinCode)) {
                ConsoleHelper.writeMessage("Поздравляем, данные введены верно");
                break;
            }
            else {
                ConsoleHelper.writeMessage("Данные кредитной карты или PIN введены неверно");
            }
        }
    }
}
