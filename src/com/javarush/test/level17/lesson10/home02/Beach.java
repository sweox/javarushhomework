package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public synchronized int compareTo(Beach o) {
        int distanceParam = (int) (distance - o.getDistance());
        int qualityParam = quality - o.getQuality();
        return 10000 * name.compareTo(o.getName()) + 100 * distanceParam + qualityParam;
    }
}

/*

    Отличная задача!
        Быть может, со мною не согласится часть аудитории. Но для меня не было приоритетом быстрота решения.
        Тяжело научить себя рассматривать задачу с различных сторон. А данная дискусия этому учит. В начале конечно, тяжело. Уже не понимаеш какие варианты могут быть еще. Но зато после решения чувствуешь, что поднялся на одну ступеньку выше.
        Чем тяжелее в учении — тем легче на практике.

        Теперь о самом решении:
        — метод int compareTo(T o) не объязан возвращать только -1, 0 или 1. Об этом еще hubert писал. (а мог бы зациклить в своем уме только три этих значения). Знать величину оличия двух элементов — бывает полезно.
        — мотоды getXXX я не синхронизировал.
        — compareTo синхронизировал и считаю это верным. На одном из этапов нить1 метод compareTo перед самым return, может уступить процессорное время другой нити2 которая изменит setXXX quality, distance или name, — тогда получится, что нить1 вернет не правильное сравение.
        — на одном из этапов я не мог пройти тестирование из-за реализации собственного метода equals согласно skipy. То есть метод equals не нужно переопределять.
        — в compareTo у меня принимают участие все три параметра. Что считаю верным.
        — Встречаются вопросы типа «Почему возле параметра name большый коофициэнт чем при qualityParam».

        return  10000 * name.compareTo(obj.getName()) + 100 * distanceParam + qualityParam;


        Для меня ответ был получен, когда глянул исходиники java библиотеки java.util.Collections, метод sort. Грубо говоря, в конечно итоге sort вызывает binarySort(a, lo, hi, lo + initRunLen); который упорядочивает по возростанию. Следовательно 10000 * name.compareTo(obj.getName()) при равных других параметрах будет закидать элемент list подальше в конец.

        П.С.:
        Я токже как и многие другие потратил на нее много времени. Решил благодаря комментариям в этом топике.
*/

/*

public class Beach {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
*/



