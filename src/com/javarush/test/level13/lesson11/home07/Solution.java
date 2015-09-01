package com.javarush.test.level13.lesson11.home07;

/* Интерфейс SimpleObject
1. Создай класс StringObject.
2. В классе StringObject реализуй интерфейс SimpleObject с параметром типа String.
3. Программа должна компилироваться.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
       SimpleObject<String> stringObject = new StringObject<Object>();
    }

    interface SimpleObject<T>
    {
        SimpleObject<T> getInstance();
    }

    public static class StringObject<Object> implements SimpleObject<String>
    {
        public SimpleObject<String> getInstance()
        {
            return StringObject.this;
            //return new StringObject<Object>();
        }
    }

}
/*
Мне также ничего не понятно. Материал какой лекции в данной задаче находит применение???

То, что в угловых скобках <>, — это дженерики, я правильно понимаю? Что означает (T) в
записи «interface SimpleObject(T) по русски? Ведь SimpleObject это на список или еще
какая куча объектов.

У меня сервер принял такое:

static class StringObject<T> implements SimpleObject<String> {

Метод getInstance() должен вернуть объект класса SimpleObject, но это интерфейс.
А следовательно, экземпляра его класса существовать не может. Поэтому возвращаем StringObject.
Он является наследником интерфейса SimpleObject (тут, наконец-то можно применить
инф-ю из лекции), следовательно его можно присвоить переменной с типом родителя.

SimpleObject<String> stringObject = new StringObject<Object>();

Но это написано до нас =(
Что надо было понять на практике в данной (и еще одной такой же ранее) задаче???
------------------------------------------------------------
Ну интерфейс SimpleObject реализует работу с объектами типа T. Класс StringObject имплементит
данный интерфейс, а значит он должен тоже работать с какими то объектами.
А строчка

SimpleObject<String> stringObject = new StringObject<Object>();

показывает что именно должен возвращать метод getInstance(), а так же он показывает
конструктор какого класса вызывается.=)
 */
/*
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        SimpleObject<String> stringObject = new StringObject<Object>();
    }

    interface SimpleObject<T>
    {
        SimpleObject<T> getInstance();
    }
}
*/