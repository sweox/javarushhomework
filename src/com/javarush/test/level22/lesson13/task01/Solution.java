package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {

//        Это почему- то не работало
// ArrayList<String> ar = new ArrayList<>();
//        if(query != null) {
//            StringTokenizer tokenizer = new StringTokenizer(query, ".");
//            while (tokenizer.hasMoreElements()) {
//                String str = tokenizer.nextToken();
//                ar.add(str);
//            }
//        }
//        String ret[] = new String[ar.size()];
//
//        ar.toArray(ret);

        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] strArr = new String[tokenizer.countTokens()];
        int i = 0;
        while(tokenizer.hasMoreElements()) {
            strArr[i] = tokenizer.nextToken();
            i++;
        }
        return strArr;
    }


}
