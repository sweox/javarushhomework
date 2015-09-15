package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Belshina on 15.09.15.
 */
public class MoldovanHen extends Hen
{
    public int getCountOfEggsPerMonth() {
        return 3;
    }
    public String getDescription() {
        return (super.getDescription() + " Моя страна - " + Country.MOLDOVA +
                ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
