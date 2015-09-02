package com.javarush.test.level13.lesson11.home05;

/* Neo
1. Реализовать интерфейс DBObject в классе User.
2. Реализовать метод initializeIdAndName так, чтобы программа работала и выводила на экран "User has name Neo, id = 1".
3. Метод toString и метод main менять нельзя.
4. Подумай, что должен возвращать метод initializeIdAndName в классе User.
*/
/**
Посмотри внимательно на код метода

public DBObject initializeIdAndName(long id, String name) {
        this.id = id;
        this.name = name;
        return new User(); // return Matrix.NEO; Уверен что проблему здесь но не вижу ее.
        }

        Ответь на 2 вопроса, для себя =)
        1. Переменную какого типа возвращает этот метод?
        Прочитай комментарий выше (NEO это ссылочная переменная типа DBObject, которая хранит ссылку на объект User.)
        2. Что обозначает слово this?
        И все у тебя получится =)
 ===============================
 1.Есть интерфейс DBObject. Следовательно?
 2.Метод initializeIdAndName должен возвращать новый создаваемый объект класса User.


 */
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(Matrix.NEO);
    }


    static class Matrix extends User
    {
       public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
    }

    interface DBObject
    {
        DBObject initializeIdAndName(long id, String name);
    }

    static class User implements DBObject
    {
        long id;
        String name;
        public DBObject initializeIdAndName(long id, String name){
            this.id = id;
            this.name = name;
            // Возвращаем User с переданными ему параметрами. Любой объект класса User является объектом
            // DBObject, поскольку он реализает все методы DBObject. Соответственно, возвращая объект User,
            // возвращаем и объект DBObject.
            // Спасибо Anton_n, info.javarush.ru
            return User.this;
        }

        @Override
        public String toString()
        {
            return String.format("User has name %s, id = %d", name, id);
        }
    }

}

/**
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(Matrix.NEO);
    }


    static class Matrix
    {
        public static DBObject NEO = new User().initializeIdAndName(1, "Neo");
    }

    interface DBObject
    {
        DBObject initializeIdAndName(long id, String name);
    }

    static class User
    {
        long id;
        String name;

        @Override
        public String toString()
        {
            return String.format("User has name %s, id = %d", name, id);
        }
    }

}
*/