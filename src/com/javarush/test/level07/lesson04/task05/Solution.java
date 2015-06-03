package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] listMax = new String[20];
        String[] listMin1 = new String[10];
        String[] listMin2 = new String[10];
        for (int i = 0; i < listMax.length; i++)
        {
            listMax[i] = reader.readLine();
        }
        for (int i = 0; i < listMax.length / 2; i++)
        {
            listMin1[i] = listMax[i];
        }
        for (int i = listMax.length / 2; i < listMax.length; i++)
        {

                listMin2[i - listMax.length / 2] = listMax[i];
                System.out.println(listMin2[i - listMax.length / 2]);


       //     System.out.println(listMin2[k]);
        }

    }
}
