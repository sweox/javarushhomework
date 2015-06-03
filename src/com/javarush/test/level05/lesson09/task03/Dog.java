package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //Напишите тут ваш код
    private String name = null;
    private int rost = 0;
    private String color = null;

    public Dog(String name)
    {
        this.name = name;
    }
    public Dog(String name, int rost)
    {
        this.name = name;
        this.rost = rost;
    }
    public Dog(String name, int rost, String color)
    {
        this.name = name;
        this.rost = rost;
        this.color = color;
    }

}
