package com.javarush.test.level13.lesson11.home10;

import java.awt.*;

/* Компиляция программы
1. Исправь классы Fox и BigFox так, чтобы программа компилировалась.
2. Метод main менять нельзя.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
       Fox bigFox = new BigFox();
       System.out.println(bigFox.getName());
       System.out.println(bigFox.getColor());
    }

    public interface Animal
    {
        Color getColor();
    }

      public abstract static class Fox implements Animal
      {
          public String getName() {
              return "Fox";
          }
          //public Color getColor() { return Color.black; }
      }

    public static class BigFox extends Fox
    {
        public Color getColor() { return Color.gray; }
    }
}
/*
Подразумевается, что Fox (Лиса) — это абстрактный класс. То есть это только
        заготовка лисы, у которой нет цвета (её ещё не покрасили). А красят
        их уже потом в конкретных реализациях. Вот поэтому метод getColor()
        реализуется отдельно в классах наследниках.
        --------------------------------

Когда перенес метод getColor() в класс BigFox и сделал класс Fox абстрактным проверка прошла.
Но хоть убей не пойму как объект bigFox «видит» метод getColor() из класса BigFox, если
ссылочная переменная для него имеет тип Fox, который не имеет в своем теле реализованного
метода getColor(). Ведь согласно теории компилятор смотрит именно на ссылочный тип и проверяет,
что бы у класса был этот метод.
Кто понял эту тему, объясните пожалуйста.

Класс Fox неявно имплементирует этот метод от интерфейса Animal, а так как класс абстрактный,
конкретная реализация не требуется, он реализуется в наследнике. Т.е. фактически сигнатура
метода присутствует, поэтому мы можем его вызвать, а реализует метод уже наследник, поэтому
на выходе мы получаем требуемый результат.
Я понимаю это так :)

Получается так, хотя всё-равно не понятно. Если бы кто-нибудь тыкнул где об этом можно
почитать, буду премного благодарен.

Попробуйте поискать самостоятельно ;) думаю это принесет гораздо больше пользы. Ориентиры:
ООП, наследование, интерфейсы, полиморфизм.
В принципе, в любом популярном учебнике об этом будет.

*/
/*
public class Solution
{

    public static void main(String[] args) throws Exception
    {
        Fox bigFox = new BigFox();
        System.out.println(bigFox.getName());
        System.out.println(bigFox.getColor());
    }

    public interface Animal
    {
        Color getColor();
    }

    public static class Fox implements Animal
    {
        public String getName() {
            return "Fox";
        }
    }

    public abstract static class BigFox
    {

    }

}
*/