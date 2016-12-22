package com.javarush.test.level30.lesson08.task01;

/* Найдем число 2 в максимальной степени
Реализуйте логику метода maxPowerOf2,
который должен возвращать число 2 в максимальной степени, которое получается поместить в переданное число
Аргументом maxPowerOf2 может быть только положительное число
Используйте только операции: 1)побитовые сдвиги, 2) присваивание, 3) побитовое ИЛИ
Не оставляйте комментарии
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxPowerOf2(140_000));   //131072
        System.out.println(maxPowerOf2(1026));      //1024
        System.out.println(maxPowerOf2(17));        //16
    }

    public static int maxPowerOf2(int x) {
        x |= (x >>  1);
        x |= (x >>  2);
        x |= (x >>  4);
        x |= (x >>  8);
        x |= (x >> 16);
        return x - (x >>> 1);
    }
}


/*
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxPowerOf2(140_000));   //131072
        System.out.println(maxPowerOf2(1026));      //1024
        System.out.println(maxPowerOf2(17));        //16
    }

    public static int maxPowerOf2(int x) {
        return x;
    }
}
*/
/*

    Как это выглядит в битах :)

        100010001011100000
        110011001111110000
        111111111111111100
        111111111111111111
        111111111111111111
        111111111111111111
        111111111111111111
        131072

        10000000010
        11000000011
        11110000011
        11111111011
        11111111111
        11111111111
        11111111111
        1024

        10001
        11001
        11111
        11111
        11111
        11111
        11111
        16
        */
