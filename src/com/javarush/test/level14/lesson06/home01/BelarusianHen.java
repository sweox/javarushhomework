package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Belshina on 15.09.15.
 */
public class BelarusianHen extends Hen
{
    public int getCountOfEggsPerMonth() {
        return 4;
    }
    public String getDescription() {
        return (super.getDescription() + " ћо€ страна - " + Country.BELARUS +
                ". я несу " + this.getCountOfEggsPerMonth() + " €иц в мес€ц");
    }
}
