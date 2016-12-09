package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 08.12.2016.
 */
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public int getTotalAmount() {
        int totalReturn = 0;
        for(Map.Entry<Integer, Integer> in: denominations.entrySet()) {
            if(!denominations.isEmpty() && in != null) {
                totalReturn += in.getKey() * in.getValue();
            }
        }
        return totalReturn;
    }

    public void addAmount(int denomination, int count) {
        if(denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        }
        else
            denominations.put(denomination, count);
    }
}
