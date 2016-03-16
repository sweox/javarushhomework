package com.javarush.test.level17.lesson10.home07;

import java.util.HashMap;
import java.util.Map;

/* ApplicationContext
ApplicationContext будет доступен множеству нитей.
Сделать так, чтобы данные не терялись: подумай, какое ключевое слово необходимо поставить и где.
*/

public abstract class ApplicationContext<GenericsBean extends Bean> {
    private Map<String, GenericsBean> container = new HashMap<String, GenericsBean>();
    //Map<Name, some class implemented Bean interface>


    protected ApplicationContext() {
        parseAllClassesAndInterfaces();
    }

    public synchronized GenericsBean getByName(String name) {
          return container.get(name);
    }

    public synchronized GenericsBean removeByName(String name) {
        return container.remove(name);
    }

    protected abstract void parseAllClassesAndInterfaces();
}
/*

public abstract class ApplicationContext<GenericsBean extends Bean> {
    private Map<String, GenericsBean> container = new HashMap<String, GenericsBean>();
    //Map<Name, some class implemented Bean interface>


    protected ApplicationContext() {
        parseAllClassesAndInterfaces();
    }

    public GenericsBean getByName(String name) {
          return container.get(name);
    }

    public GenericsBean removeByName(String name) {
        return container.remove(name);
    }

    protected abstract void parseAllClassesAndInterfaces();
}
*/
/*

    Могу описать как это вижу я.

        Задавая container как volatile, мы указывает только, что данные нужно брать напрямую
        из медленной памяти, а не из кеша. Но по условию задачи, ApplicationContext может
        быть использован несколькими нитями. И можно представить ситуацию, когда нить А
        вызывает метод get(«Element10»), получает ссылку на объект GenericsBean и замирает
        передав управление нити B. Нить B в свой цикл вызывает метод remove(«Element10»)
        тем самым удалив объект из HashMap. Дальше управление возвращается нити А, но
        объект уже удален из container и ссылка полученная ранее уже не действительна.
        Добавляя synchronized мы страхуемся от такой ситуации. volatile нам гарантирует
        только идентичный container при последовательном обращении(т.е. нить А удалила
        объект, нить Б при следующем обращении это увидит). Если же нить А обратиться к
        элементу container, а нить Б удалит его, то нить А повторно обращаться к нему не
        будет, т.к. будет считать, что у нее уже есть актуальная информация на счет
        полученного элемента.
*/
