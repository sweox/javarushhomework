package com.javarush.test.level04.lesson10.task04;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в одной строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int l = 0;
        //int s = 0;
        while (l < 10)
        {
            int s = 0;
            while (s < 10)
            {
                System.out.print("S");
                s++;
            }
            System.out.println();
            l++;
        }


    }
}
