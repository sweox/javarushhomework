package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);
    static {
        threads.add(new UnContyniusThread());
        threads.add(new InterExceptionThread());
        threads.add(new UraThread());
        threads.add(new MessageThread());
        threads.add(new NumberThread());
    }
    static class UnContyniusThread extends Thread {
        public void run() {
            while(true) {}
        }

    }
    static class InterExceptionThread extends Thread {
        public void run() {
            while(true) {
                if (Thread.interrupted()) {
                    try {
                        throw new InterruptedException();
                    }
                    catch (InterruptedException e) {
                        System.out.println("InterruptedException");
                    }
                }
            }
        }

    }
    static class UraThread extends Thread {
        public void run() {
            while(true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                }
                catch(InterruptedException e) {}
            }
        }
    }
    static class MessageThread extends Thread implements Message {

        public  void showWarning()
        {
            this.interrupt();
            try {
                this.join();
            }
            catch(Exception e) {}
        }

        @Override
        public void run() {
            Thread current = Thread.currentThread();
            while(!current.interrupted()) {}
        }

//        boolean breaks = false;
//        public void run() {
//            while(!breaks) {
//
//            }
//        }
//        public void showWarning() {
//                breaks = true;

//            try {
//                join();
//            }
//            catch (InterruptedException e) {
//            }
//        }
    }
    static class NumberThread extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer count = 0;
        public void run() {
            try {
                String read;
                while(!(read = reader.readLine()).equals("N"))
                {
                    count = count + Integer.parseInt(read);
                }
                System.out.println(count);
            }
            catch (IOException e) {
            }

        }
    }

//    public static void main(String[] args)
//    {
//        MessageThread _4 = (MessageThread)threads.get(3);
//        _4.start();
//        System.out.println(_4.isAlive());
//        _4.showWarning();
//        System.out.println(_4.isAlive());
//    }
}
/*

    Если ещё актуально, я вот тут, как раз тот же случай, бери тот мейн и тестируй.
        И ещё, один маленький совет,
        Thread.currentThread().interrupt();
        так, и только такможно и нужно вызывать метод interrupt() только в том случае если ты в своем классе просто
        реализуешь интерфейс
        implements Runable
        , если же ты наследуешься от класса трэд
        extends Thread
        (как в твоём случае), то достаточно вызывать его просто так
        interrupt();
        , т.к. это уже унаследованный метод, и вызван он будет именно у той нити из которой вызывается.
        Это такой, интересный нюанс =) Я сам долгое время не мог понять в чём конкретно разница, работает вроде и
        так, и так...)
*/

    /*
    всёравно не понимаю механизма интерапта и почему нужен join()
объясняю.
        Тут важнее разобраться не с механизмом работы интерапта, а с механизмом работы join().
        1) механизмом работы интерапта прост как пять копеек, грубо говоря this.interrupt() просто выкидывает флаг прерывания для для нити this, он нечего фактически не останавливает, а ты уже что хочешь с этим флагом, то и делаешь, хочешь, отрабатываешь его, хочешь месседж какой в консоль выведи, а хочешь тупо игнорь. Что бы как — то на него реально отреагировать и действительно завершить нить этот
        while (!isInterrupted()) {
        }
        цикл и пишется, он просто отслеживает этот флаг интерапта для this нити. Хочешь можешь прописать
        do
        {
        if (isInterrupted()){
        System.out.println("Прощай, любимый мой, родной!");
        }
        }while (!isInterrupted());
        тогда нить попрощается с тобой перед завершением), хочешь подвешиваешь любое другое действие на флаг прерывания, вообщем как поступить с этим флагом, решаешь только ты, сам по себе он ничего не завершает. Такс, с интераптом я думаю разобрались…
        2) Вот с join() тут уже всё поинтересней будет)
        Что именно делает метод join()? Метод join() ожидает завершения нити, для которой он вызван, другими словами когда вы вызывается Thread.join(), вызывающая нить блокируется до завершения работы целевой нити.
        А вот теперь ВНИМАНИЕ гвоздь программы!
        ВОПРОС на засыпку: из какой нити и для какой нити вызывается join() (в правильном варианте решения задачи)? То есть какая нить у нас вызывающая, а какая целевая??? =)
        ОТВЕТ:вызывающая нить main, а целевая нить thread4!!! То есть вызвать из main
        message.showWarning();
        в данном случае будет равносильно этому коду в main:
        thread4.interrupt();
        thread4.join();
        System.out.println(thread4.isAlive());
        и эта строчка
        System.out.println(thread4.isAlive());
        не выполниться до тех пор пока thread4 не завершиться.
        Надеюсь теперь всё понятно по этой задаче, по interrupt(), и по join().
        Всем спасибо за внимание =)
*/

/*
    Для всех кто уверен что всё правильно, но не проходит тестирование.
        Решение — метод showWarning(): интерфейса который есть в задании.
        По непонятной мне до сих пор причине этот метод должен дождаться завершения текущей нити.

        Это стандартный прием правильной остановки нити. Т.к. остановка нити может требовать определенных
        завершающих действий (ну или просто проверка не сразу производится), а в это время останавливающая
        нить может пройти вперед.
        */

/*
    Потому что currentThread() — это далеко не всегда this Thread.
        Например ведь если метод showWarning() вызывается из main Thread, то если прописать
        currentThread().interrupt();
        то флаг прерывания будет выброшен для нити main(т.е. для той нити которая этот метод вызвала, которая в
        данный момент выполняется), а вот если прописать
        this.interrupt();
        или просто
        interrupt();
        то, независимо от того из какой нити этот метод был вызван, флаг будет выброшен именно у this нити, т.е. у
        того экземпляра Thread, в котором он был вызван.
        */
