package com.javarush.test.level17.lesson10.home05;

/* Лишняя синхронизация
synchronized существенно замедляет программу, поэтому убери избыточность synchronized внутри методов
*/

public class Solution {
    char[] value;
    int count;

    public Solution append(CharSequence s) {

            if (s == null) {

                    s = "null";

            }

            if (s instanceof String) {

                    return this.append((String) s);

            }

            if (s instanceof Solution) {

                    return this.appendThis((Solution) s);

            }

        return this.append(s);
    }

    public synchronized Solution appendThis(Solution s) {
        //do something here....
        return this;
    }

    private static final java.io.ObjectStreamField[] serialPersistentFields =
            {
                    new java.io.ObjectStreamField("value", char[].class),
                    new java.io.ObjectStreamField("count", Integer.TYPE),
                    new java.io.ObjectStreamField("shared", Boolean.TYPE),
            };

    private synchronized void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        java.io.ObjectOutputStream.PutField fields = s.putFields();

            fields.put("value", value);
            fields.put("count", count);
            fields.put("shared", false);


            s.writeFields();

    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {

            java.io.ObjectInputStream.GetField fields = s.readFields();
            value = (char[]) fields.get("value", null);
            count = fields.get("count", 0);

    }
}

/*

public class Solution {
    char[] value;
    int count;

    public Solution append(CharSequence s) {
        synchronized (Solution.class) {
            if (s == null) {
                synchronized (this) {
                    s = "null";
                }
            }

            if (s instanceof String) {
                synchronized (this) {
                    return this.append((String) s);
                }
            }

            if (s instanceof Solution) {
                synchronized (this) {
                    return this.appendThis((Solution) s);
                }
            }
        }
        return this.append(s);
    }

    public synchronized Solution appendThis(Solution s) {
        //do something here....
        return this;
    }

    private static final java.io.ObjectStreamField[] serialPersistentFields =
            {
                    new java.io.ObjectStreamField("value", char[].class),
                    new java.io.ObjectStreamField("count", Integer.TYPE),
                    new java.io.ObjectStreamField("shared", Boolean.TYPE),
            };

    private synchronized void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        java.io.ObjectOutputStream.PutField fields = s.putFields();
        synchronized (fields) {
            fields.put("value", value);
            fields.put("count", count);
            fields.put("shared", false);
        }
        synchronized (s) {
            s.writeFields();
        }
    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        synchronized (new java.io.IOException()) {
            java.io.ObjectInputStream.GetField fields = s.readFields();
            value = (char[]) fields.get("value", null);
            count = fields.get("count", 0);
        }
    }
}

*/
/*

    В решении этой задачи есть логика. Намного проще, чем предыдущая, плюс в самом задании подсказка. Если у нас
        метод синхронизирован, то уже внутри ничего синхронизировать не нужно. Создавать объект и по нему чего-то
        синхронизировать — явная ерунда. Синхронизировать весь класс нужно только когда есть что-то статическое.
        Синхронизировать атомарную операцию не нужно. Синхронизировать применение синхронизированного метода не
        нужно. Единственное, что осталось под вопросом, — оно смотрится неестественно, т.к. по идее программа не
        должна проходить через точку синхронизации миллион раз. Поэтому ее тоже удаляем — и вуаля, метод научного
        тыка рулит :)

        Но если кто это читает — посмотрите плиз мои комменты к предыдущей задаче на синхронизацию
        info.javarush.ru/JavaRush_tasks_discussion/2013/09/16/level17-lesson10-home04.html

        Там вообще ничего не понятно.
*/
