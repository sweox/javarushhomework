package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Belshina on 15.09.15.
 */
public class UkrainianHen extends Hen
{
    public int getCountOfEggsPerMonth() {
        return 5;
    }
    public String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.UKRAINE +
                ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
