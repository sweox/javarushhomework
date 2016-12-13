package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;


/**
 * Created by BELSHINA on 13.12.2016.
 */
public class LoginCommand implements Command {
    private String cardNumber = "123456789012";
    private String pinCode = "1234";

    private ResourceBundle validCreditCards
            = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.verifiedCards");
    public void execute() throws InterruptOperationException {
        String cardNumberReader;
        String pinCodeReader = "";
        while(true) {
            ConsoleHelper.writeMessage("Введите номер кредитной карты");
            cardNumberReader = ConsoleHelper.readString();
            ConsoleHelper.writeMessage("Введите PIN-код");
            pinCodeReader = ConsoleHelper.readString();
            if(validCreditCards.containsKey(cardNumberReader)
                    && validCreditCards.getString(cardNumberReader).equals(pinCodeReader)) {
                ConsoleHelper.writeMessage("Поздравляем, данные введены верно");
                break;
            }
            else {
                ConsoleHelper.writeMessage("Данные кредитной карты или PIN введены неверно");
            }
        }
    }


}
