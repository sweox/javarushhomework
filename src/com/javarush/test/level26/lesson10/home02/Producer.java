package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by BELSHINA on 23.12.2016.
 */

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i = 0;
        try{
            while(!Thread.currentThread().isInterrupted()) {
                map.put(Integer.toString(++i), "Some text for " + i);
                Thread.sleep(500);
            }

        }
        catch(InterruptedException e) {
            System.out.printf("[%s] thread was terminated", Thread.currentThread().getName());
            //Thread.currentThread().interrupt();
        }
    }
}

//Этого класса изначально не было