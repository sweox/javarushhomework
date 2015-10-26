package com.javarush.test.level16.lesson05.task02;

import java.util.ArrayList;
import java.util.List;

/* Horse Racing
Разберись, что делает программа.
Реализуй метод calculateHorsesFinished. Он должен:
1. Посчитать количество финишировавших лошадей и возвратить его. Используй метод isFinished().
2. Если лошадь еще не пришла к финишу (!isFinished()), то:
2.1. Вывести в консоль "Waiting for " + horse.getName().
2.2. Подождать, пока она завершит гонку. Подумай, какой метод нужно использовать для этого.
*/
/*
http://habrahabr.ru/post/164487/
https://ru.wikipedia.org/wiki/%D0%9F%D0%BE%D1%82%D0%BE%D0%BA_%D0%B2%D1%8B%D0%BF%D0%BE%D0%BB%D0%BD%D0%B5%D0%BD%D0%B8%D1%8F
Как я это понял:

В лекции сказано, что приостанавливает свою работу та нить, которая вызвала метод. То есть:
мы идём по списку от 1 до 10 и проверяем — прибежала ли n-ая лошадь из списка. Соответственно,
если уже добежала другая лошадь (т.е. до треда 7 дошла очередь раньше чем до треда 1*),
то мы просто принимаем это к сведению: надпись про то что лошадь финишировала выводится её
потоком, а не тем, который мы остановили.

А остановили мы тот поток, который «ожидает» лошадей, т.е. если закомментировать в этом
месте h.join(), то экран затопит кучей «Waiting for horse_NN», пока все лошади не добегут.
Соответственно, как только мы дождались, нашей лошади, мы продолжаем проверять дальнейшие
элементы из списка, пропуская тех, кто уже добежал. Можно представить это как будто
наблюдатель сидит на ипподроме и отслеживает по списку всех бегущих лошадей начиная с
первой и не переключаясь на следующую, пока первая не добежит.

 а почему так может происходить, рассказано в ссылке выше от hubert'а
 =========================
 Чтобы понять, что здесь происходит, стоит помнить одну вещь. Фраза «Waiting for Horse_NN»
 не означает, как кажется на первый взгляд, что все лошади (нити, потоки, «маленькие роботы»)
 должны остановиться и ждать, пока не финиширует какая-то одна лошадь (нет, все они
 продолжают свою работу параллельно друг с другом и последовательно исполняют свои
 текущие команды в методе run() до его завершения). Фраза «Waiting for Horse_NN» означает,
 что должен остановиться один основной поток и ждать, пока не финиширует первая лошадь в
 списке, которая ещё не успела финишировать, и лишь затем продолжить свою работу, исполнять
 цикл while (при этом, пока основной поток ждёт, пока текущая в списке лошадка доскачет,
 другие лошади могут уже финишировать, о чём и будет свидетельствовать вывод на экран).
 */
public class Solution {
    public static int countHorses = 10;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart();
        while (calculateHorsesFinished(horses) != countHorses) {
        }
    }

    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int countFinished = 0;
        //add your implementation here - добавь свою реалзацию тут
/*        for (Horse x:horses) {
            if (x.isFinished()) {
                countFinished++;
            }
            else if(!x.isFinished()) {
                System.out.println("Waiting for " + x.getName());
                x.join();
            }
        }*/
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).isFinished()) {
                countFinished++;
            }
            else if (!horses.get(i).isFinished()) {
                System.out.println("Waiting for " + horses.get(i).getName());
                //horses.get(i).join();
            }
        }
        return countFinished;
    }

    public static class Horse extends Thread {

        public Horse(String name) {
            super(name);
        }

        private boolean isFinished;

        public boolean isFinished() {
            return isFinished;
        }

        public void run() {
            String s = "";
            for (int i = 0; i < 1001; i++) {   //delay
                s += new String("" + i);
                if (i == 1000) {
                    s = " has finished the race!";
                    System.out.println(getName() + s);
                    isFinished = true;
                }
            }
        }
    }

    public static List<Horse> prepareHorsesAndStart() {
        List<Horse> horses = new ArrayList<Horse>(countHorses);
        String number;
        for (int i = 1; i < countHorses + 1; i++) {
            number = i < 10 ? ("0" + i) : "" + i;
            horses.add(new Horse("Horse_" + number));
        }

        for (int i = 0; i < countHorses; i++) {
            horses.get(i).start();
        }
        return horses;
    }
}
