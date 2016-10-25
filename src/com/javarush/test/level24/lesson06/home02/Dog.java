package com.javarush.test.level24.lesson06.home02;

import java.util.Date;

/*
В работе вам иногда будет нужно закастить класс к какому-нибудь другому классу, не интерфейсу :)))
Класс DogPet использует 2 класса - SuperDog и Dog, разберись с getName в классе DogPet
Так намного лучше, чем Copy+Paste!
 */
public class Dog implements Pet {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    /**
     * Если так получилось, что есть готовый класс А (тут SuperDog) с логикой, которую вы хотите использовать.
     * То возможны 3 способа:
     * 1) из класса А скопировать логику себе (это плохо, т.к. поддерживать несколько копий одного и того же кода проблематично)
     * 2) создать экземпляр класса А внутри нашего класса и использовать его, связь has-a (не всегда подходит, т.к. класс А сам по себе)
     * 3) создать внутренний класс, который наследуется от А, использовать его методы вместе с
     * методами и полями нашего класса, т.к. внутренний класс имеет доступ к своему родителю как наследник,
     * а также ко всем полям и методам включая private того класса, в который он вложен.
     * <p/>
     * Итак, разбираемся с п.3:
     * Внутри метода toSayable создайте class DogPet, который наследуется от SuperDog и реализует интерфейс Sayable
     * создайте метод private String getName(), который будет использовать логику двух классов - Dog и SuperDog.
     * Пусть этот метод возвращает имя собаки (класс Dog), которое с обеих сторон выделено getSuperQuotes (класс SuperDog)
     * Пример, " *** Барбос *** "
     * Логика метода say:
     * Если i <= 0, то используя метод getName вывести на экран, что собака спит. Пример, " *** Шарик ***  спит."
     * Иначе вывести фразу: "имя_собаки лает гааав! сегодняшняя_дата". Пример для i=3, " *** Тузик ***  лает гааав! 13-ноя-2013 Ср"
     * Для форматирования даты используйте formatter из класса SuperDog.
     * <p/>
     * <b>Пример вывода:</b>
     *  *** Барбос ***  лает гааааав! 13-ноя-2013 Ср
     *  *** Тузик ***  лает гаав! 13-ноя-2013 Ср
     *  *** Бобик ***  лает гааав! 13-ноя-2013 Ср
     * Мыша пищит.
     *  *** Шарик ***  спит.
     *
     * @param i количество букв 'а' в слове гав
     * @return экземпляр класса DogPet
     */


    public Sayable toSayable(final int i) {
        class DogPet extends SuperDog implements Sayable {
            private String getName() {
                return getSuperQuotes() + name + getSuperQuotes();
            }
            public String say() {
                StringBuilder sb = new StringBuilder();
                if (i <= 0) {
                    return sb.append(getName()).append(" спит.").toString();
                }
                else {
                    sb.append(getName()).append(" лает г");
                    for(int j = 0; j < i; j++) {
                        sb.append("а");
                    }
                    System.out.println(getName());
//                    System.out.println(String.format(String.format("%%%ds", i), " ").replace(" ",getName()));
//                    System.out.println(String.format("%0"+i+"d", 0).replace("0", getName()) + i);
                    return sb.append("в! ").append(formatter.format(new Date())).toString();
                }
            }
        }
        return new DogPet();
    }

    /*public Sayable toSayable(final int i) {
        class DogPet extends SuperDog implements Sayable {
            public String say() {
                if (i <= 0) {
                    return getName() + " спит.";
                }
                else {
                    String result = getSuperQuotes() + name + getSuperQuotes();
                    result = result + " лает г";
                    for (int ii = 1; ii <= i; ii++) {
                        result = result + "a";
                    }
                    return result + "в! " + formatter.format(new Date());
                }
            }
            private String getName() {
                return getSuperQuotes() + name + getSuperQuotes();
            }
        }
        return new DogPet();
    }*/

}

 /*
    public Sayable toSayable(final int i) {

        return null;
    }


}
*/
