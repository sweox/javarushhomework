package com.javarush.test.level10.lesson11.home09;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов. Нужно подсчитать количество одинаковых слов в списке.
Результат нужно представить в виде словаря Map<String, Integer>, где первый параметр – уникальная
 строка,
а второй – число, сколько раз данная строка встречалась в списке.
Вывести содержимое словаря на экран.
В тестах регистр (большая/маленькая буква) не влияет на результат.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++)
        {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list)
    {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        //Напишите тут ваш код
/**
//----------------------Первый вариант-------------------------
        for (int i = 0; i < list.size(); i++)
        {
            int k = 0;
            for (int j = 0; j < list.size(); j++)
            {

                if (list.get(i).equals(list.get(j)))
                {
                    k++;
                }
                //result.put(list.get(i), k);
            }
            result.put(list.get(i), k);
        }
 */
 /**
 //---------------------Второй вариант (не мой)-------------------------

        for (String word:list)
        {
            // what's written here makes me lose my mind.
            result.put(word, result.containsKey(word)?result.get(word)+1:1);
        }
  */
//-------------------Третий элемент----------------
        for (String a:list)
        {
            int h = 0;
            for(String b:list)
            {
                if (a.equals(b))
                    h++;
            }
            result.put(a, h);
        }
/*
//--------------Четвертый вариант----------------
        for (String word : list)
        {
            if (result.containsKey(word))
                result.put(word, result.get(word)+1);
            else
                result.put(word, 1);
        }
*/
        return result;
    }

}
