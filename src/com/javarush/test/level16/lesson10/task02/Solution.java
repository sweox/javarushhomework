package com.javarush.test.level16.lesson10.task02;

/* Отсчет на гонках
1. Разберись, что делает программа.
2. Реализуй логику метода run так, чтобы каждую секунду через пробел
выдавался отсчет начиная с countSeconds до 1, а потом слово [Марш!] (см примеры).
3. Если нить работает 3.5 секунды или более, прерви ее методом interrupt и внутри нити выведи в
консоль слово [Прервано!].
Пример для countSeconds=4 : [4 3 2 1 Прервано!]
4. Если нить работает менее 3.5 секунд, она должна завершиться сама.
Пример для countSeconds=3 : [3 2 1 Марш!]
PS: метод sleep выбрасывает InterruptedException.
*/

/*
Когда ты вызываешь interrupt() он меняет состояние не isInterrupted, а состояния флага у данного
потока(нити). Метод sleep() проверяет состояние флага и если он установлен, то выбрасывает
InterruptedException, а обработчик исключений сбрасывает состояние флага на обычное. Убери
Thread.sleep(500) стоящую после вызова interrupt и ты убедишься в этом.
Если надо срочно завершить процесс используй return;
Спасибо за хороший вопрос.
Почитай вот это (http://javaforcats.blogspot.com.by/2013/03/threadcurrentthreadinterrupt.html)
и это (http://stackoverflow.com/questions/2491588/how-a-thread-should-close-itself-in-java)
 */
public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try {
                for (int i = countSeconds; i > 0; i--) {
                    System.out.print(i + " ");
                    Thread.sleep(1000);
                }
                System.out.print("Марш!");
            }
            catch (InterruptedException e){
                System.out.print("Прервано!");
            }
        }
    }
}

/*

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут

    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут

        }
    }
}
*/
