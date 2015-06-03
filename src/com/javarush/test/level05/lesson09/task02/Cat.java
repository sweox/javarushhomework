package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес не известен, то нужно указать
какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может
и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //Напишите тут ваш код
    private String name = null;
    private int age = 0;
    private int weight = 0;
    private int defaultWeight = 5;
    private String color = null;
    private String address = null;

    public Cat(String name)
    {
        this.name = name;
        this.weight = this.defaultWeight;
    }
    public Cat(String name, int weight, int age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }
    public Cat(String name, int age)
    {
        this.name = name;
        this.age = age;
        this.weight = this.defaultWeight;
    }
    public Cat(int weight, String color)
    {
        this.weight = weight;
        this.color = color;
    }
    public Cat(int weight, String color, String address)
    {
        this.weight = weight;
        this.color = color;
        this.address = address;
    }

}
