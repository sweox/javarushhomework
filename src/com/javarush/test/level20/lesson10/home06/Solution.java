package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream out) throws NotSerializableException
        {
            throw new NotSerializableException();
        }
        private void readObject(ObjectInputStream in) throws NotSerializableException
        {
            throw new NotSerializableException();
        }
    }
    public static void main(String[] args) throws IOException
    {
        SubSolution sSol = new SubSolution();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:/77.txt"));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:/77.txt"));
        out.writeObject(sSol);
    }

}

/*

public class Solution implements Serializable {
    public static class SubSolution extends Solution {

    }

}
*/
