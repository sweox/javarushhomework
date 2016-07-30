package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Properties prop = new Properties();
        try
        {
            prop.load(new FileInputStream(reader.readLine()));
//            Enumeration e = prop.propertyNames();
//            for(; e.hasMoreElements();) {
//                String key = (String)e.nextElement();
//                properties.put(key, prop.getProperty(key));
//            }
            for(String s : prop.stringPropertyNames()) {
                Solution.properties.put(s, prop.getProperty(s));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter printWriter = new PrintWriter(outputStream);
        for(Map.Entry<String, String> ma : Solution.properties.entrySet()) {
            printWriter.println(ma.getKey());
            printWriter.println(ma.getValue());
        }
        printWriter.flush();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while(reader.ready()) {
            properties.put(reader.readLine(), reader.readLine());
        }
    }

}

/*

public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод

    }
    public static void main(String[] args) throws Exception
    {
        System.out.println(Solution.properties);
        Solution s = new Solution();
        s.fillInPropertiesMap();
        for(Map.Entry<String, String> sd : Solution.properties.entrySet()) {
            System.out.println(sd.getKey() + "-----" + sd.getValue());
        }
        FileOutputStream out = new FileOutputStream("c:/2.txt");
        FileInputStream in = new FileInputStream("c:/2.txt");

        Solution sol1 = new Solution();
        sol1.save(out);

        Solution sol2 = new Solution();
        sol2.load(in);
        System.out.println(Solution.properties);

    }

}
*/
