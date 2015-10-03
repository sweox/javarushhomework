package com.javarush.test.level15.lesson12.home01;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.

*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String r = null;
        //int in = Integer.parseInt(r); //NumberFormatException null
        while (!(r = reader.readLine()).equals("exit")) {
            try {
                if (r.indexOf('.') > 0) {
                    print(Double.parseDouble(r));
                }
                else if ((Integer.parseInt(r) > 0) && (Integer.parseInt(r) < 128)) {
                    print((short)Integer.parseInt(r));
                }
                else if (Integer.parseInt(r) >= 128) {
                    print(Integer.parseInt(r));
                }
                else print(r);
            }

            catch (NumberFormatException e) {
                print(r);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
//===========================================================
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
*/
//===========================================================================
/*
public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Object> myObjects = new ArrayList<Object>();
        String tempString;
        short shortValue;
        Double doubleValue;
        Integer intValue;
        while (true) {
            tempString = reader.readLine();
            if (tempString.equals("exit")) {
                break;
            }
            if (isItDouble(tempString)&&containsDot(tempString)) {
                doubleValue = Double.parseDouble(tempString);
                myObjects.add(doubleValue);
            }
            else if (isItShort(tempString)) {
                shortValue = Short.parseShort(tempString);
                myObjects.add(shortValue);
            }
            else if (isItInteger(tempString)) {
                intValue = Integer.parseInt(tempString);
                myObjects.add(intValue);
            }
            else {
                myObjects.add(tempString);
            }
        }

        for (Object o : myObjects) {
            if (o instanceof Double) {
                print(((Double) o));
            }
            if (o instanceof Short) {
                print(((Short) o));
            }
            if (o instanceof Integer) {
                print((Integer) o);
            }
            if (o instanceof String) {
                print((String)o);
            }
        }
    }

    public static boolean containsDot(String inputString){
        char[]tempChar = inputString.toCharArray();
        boolean flag = false;
        for (char myChar : tempChar) {
            if (myChar == '.') {
                flag=true;
                break;
            }
        }
        return flag;
    }

    public static boolean isItDouble (String inputString) {
        boolean flag = true;
        try
        {
            Double myDouble = Double.parseDouble(inputString);
        }
        catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    }

    public static boolean isItInteger (String inputString) {
        boolean flag = false;
        int tempInteger;
        try
        {
            tempInteger = Integer.parseInt(inputString);
            if(tempInteger > 0 && tempInteger < 128) {
            }
            else {
                flag = true;
            }
            return flag;
        }
        catch (NumberFormatException e) {
            return flag;
        }
    }

    public static boolean isItShort (String inputString) {
        boolean flag = true;
        try {
            int tempValue = Integer.parseInt(inputString);
            if (tempValue > 0&&tempValue < 128) {
                return flag;
            }
            else {
                flag = false;
                return flag;
            }
        }
        catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}*/
