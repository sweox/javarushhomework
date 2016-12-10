package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

/**
 * Created by BELSHINA on 10.12.2016.
 */
class InfoCommand implements Command {
    public void execute() {
        System.out.println(CurrencyManipulatorFactory.getManipulatorByCurrencyCode("USD").getTotalAmount());
    }
}
