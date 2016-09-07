package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome {
    ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public static void main(String[] args) {
        game = new Hippodrome();
        Horse horse1 = new Horse("Horse1", 3, 0);
        Horse horse2 = new Horse("Horse2", 3, 0);
        Horse horse3 = new Horse("Horse3", 3, 0);

        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();

        game.printWinner();

    }

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public Horse getWinner() {
        Horse win = null;
        for(Horse h : horses) {
            if (win == null) {
                win = h;
            }
            else if(h.getDistance() > win.getDistance()) {
                win = h;
            }
        }
        return win;

    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {}
        }
    }

    public void move() {
        for (Horse h : horses) {
            h.move();
        }
    }

    public void print() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        System.out.println();
        System.out.println();
    }
}
