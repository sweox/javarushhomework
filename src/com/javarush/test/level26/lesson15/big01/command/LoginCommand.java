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

    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.login_en");

    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String cardNumberReader;
        String pinCodeReader = "";
        while(true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            cardNumberReader = ConsoleHelper.readString();
            pinCodeReader = ConsoleHelper.readString();
            if(validCreditCards.containsKey(cardNumberReader)
                    && validCreditCards.getString(cardNumberReader).equals(pinCodeReader)) {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumberReader));
                break;
            }
            else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumberReader));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        }
    }


}
