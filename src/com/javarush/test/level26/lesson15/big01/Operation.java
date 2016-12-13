package com.javarush.test.level26.lesson15.big01;

public enum Operation {
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) throws IllegalArgumentException {

        int[] realOrder = new int[values().length];
        int checkI = i;
        if(checkI <= 0 || checkI >= realOrder.length) {
            throw new IllegalArgumentException();
        }
        else {
            return values()[i];
        }
    }
}
