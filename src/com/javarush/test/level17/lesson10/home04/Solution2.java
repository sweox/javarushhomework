package com.javarush.test.level17.lesson10.home04;

/**
 * Created by Belshina on 14.03.16.
 */
public class Solution2 extends Thread
{
    private double param = Math.random();
    private StringBuilder sb = new StringBuilder();

    private void method0() {
        double i = method3();
    }

    protected synchronized void method1(String param1) {
        Solution2 solution = new Solution2();
        solution.method0();
    }

    public void method2(int param1) {
        param1++;
    }

    synchronized double method3() {
        double random = Math.random();
        param += 40.7;
        return random + param;
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
    public void run() {
//        while(true)
//        {
            method0();
            method1("method1");
            method2(2);
            method3();
            method4();
            method5("method5");
            System.out.println(method6(6));
            method7(9.0);
//        }
    }

    public static void main(String[] args)
    {
        for(int i = 1; i <=100; i++) {
            new Solution2().start();
        }
    }
}
