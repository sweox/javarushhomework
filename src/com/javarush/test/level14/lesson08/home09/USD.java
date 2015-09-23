package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Admin on 23.09.2015.
 */
public class USD extends Money
{
    //public double amount;

    public String getCurrencyName()
    {
        //return this.getClass().getSimpleName();
        return "USD";
    }
    public USD(double amount)
    {
        super(amount);
        //this.amount = amount;
    }
    public double getAmount()
    {
        return super.getAmount();
        //return this.amount;
    }
}
