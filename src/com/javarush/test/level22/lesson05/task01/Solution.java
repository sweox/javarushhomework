package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до
конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String ret = "";
        if (string == null) {
            throw new TooShortStringException();
        }
        String strArr[] = string.split(" ");
        if (strArr.length > 4) {
            ret = strArr[1] + " " + strArr[2] + " " +strArr[3] + " " +strArr[4];
        }
        else
            throw new TooShortStringException();
        return ret;
    }



    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
//        System.out.println(Solution.getPartOfString("JavaRush-лучшийсервисобученияJava."));
        System.out.println(Solution.getPartOfString("JavaRush - лучший сервисобучения Java."));
    }
}
/*

public class Solution {
    public static String getPartOfString(String string) {

        return null;
    }

    public static class TooShortStringException {
    }

}
*/
