package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;

public final class CurrencyManipulatorFactory {
    private CurrencyManipulatorFactory() {}
    private static HashMap<String, CurrencyManipulator> manipulatorHashMap = new HashMap<>();
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        CurrencyManipulator manipulator;
        if(manipulatorHashMap.containsKey(currencyCode)) {
            return manipulatorHashMap.get(currencyCode);
        }
        else {
            manipulator = new CurrencyManipulator(currencyCode);
            manipulatorHashMap.put(currencyCode, manipulator);
            return manipulator;
        }
    }
    public static Collection getAllCurrencyManipulators() {
        return manipulatorHashMap.values();
    }

}
