package com.javarush.test.level04.lesson16.home03;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму
и завершить программу.  -1 должно учитываться в сумме.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       /** int sum = 0;
        Boolean isExit=false;
        while (!isExit)
        {
            String d = reader.readLine();
            int intD = Integer.parseInt(d);

            sum += intD;
            isExit = d.equals("-1");
            System.out.println(sum);
        }*/

            int sum = 0;
            while(true)
            {
                String g = reader.readLine();
                int intG = Integer.parseInt(g);

                sum += intG;

                if (g.equals("-1"))
                {
                    System.out.println(sum);
                    break;
                }

            }

    }
}
