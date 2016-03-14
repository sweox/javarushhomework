package com.javarush.test.level17.lesson10.home04;

/**
 * Created by Belshina on 14.03.16.
 */
public class Solution3
{
    private double param = Math.random() ;
    private StringBuilder sb = new StringBuilder();

    private void method0() {
        double i = method3();
        System.out.println("method0 - " + i);
    }

    protected synchronized void method1(String param1) {
        Solution3 solution3 = new Solution3();
        //Solution3 solution3 = n
        //solution.method0();
        System.out.println("solution3 param method1 - " + solution3.param);
        System.out.println("solution3 in method3 (param + 40.7 = " + solution3.method3() + ")");
        //System.out.println("solution3 param method1 - " + solution3.param);
    }

    public void print() {
        System.out.println("s param - " + param);
    }

    public void method2(int param1) {
        param1++;
    }

    synchronized double method3() {
        double random = Math.random();
        //System.out.println("random method3 - " + random);
        return param = param + 40.7;
        //return random + param;
    }

    private synchronized void method4() {
        sb.append(1).append(1).append(1).append(1);
    }

    protected void method5(String param2) {
        new StringBuffer().append(param2).append(param2).append(param2);
    }

    public synchronized String method6(int param2) {
        System.out.println("Thinking....");
        method7(5e-2);
        sb = new StringBuilder("Got it!.");
        return sb.toString();
    }

    String method7(double param2) {
        return "" + param2;
    }

    public static void main(String[] args)
    {
        Solution3 s = new Solution3();
        s.print();
        s.method1("j");
        s.print();
        s.method3();
        s.print();
    }
}
