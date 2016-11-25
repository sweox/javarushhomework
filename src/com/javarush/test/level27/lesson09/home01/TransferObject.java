package com.javarush.test.level27.lesson09.home01;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while(!isValuePresent) {
            try {
                this.wait();
            }
            catch (InterruptedException e) { }
        }
        System.out.println("Got: " + value);
        isValuePresent = false;
        notifyAll();

        return value;
    }

    public synchronized void put(int value) {
        if(isValuePresent) {
            try {
                this.wait();
            }
            catch (InterruptedException e) {}
        }
        this.value = value;
        System.out.println("Put: " + value);
        isValuePresent = true;
        notifyAll();
    }
}

/*

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        System.out.println("Got: " + value);
        return value;
    }

    public synchronized void put(int value) {
        this.value = value;
        System.out.println("Put: " + value);
    }
}
*/

