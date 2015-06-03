package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    //Напишите тут ваш код
    private String name = null;
    private int rost;
    private String color = null;

    public void initialize(String name)
    {
        this.name = name;
    }
    public void initialize(String name, int rost)
    {
        this.name = name;
        this.rost = rost;
    }
    public void initialize(String name, int rost, String color)
    {
        this.name = name;
        this.rost = rost;
        this.color = color;
    }

}
