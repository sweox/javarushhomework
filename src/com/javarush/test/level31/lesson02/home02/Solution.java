package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        Deque<File> deque = new ArrayDeque<>();
        List<String> listFromFile = new ArrayList<>();
        File file = new File(root);

        deque.push(file);
        while(!deque.isEmpty()) {
            File popFromDeque = deque.pop();
            if(popFromDeque.isFile()) {
                listFromFile.add(popFromDeque.getAbsolutePath());
            }
            else if(popFromDeque.isDirectory()) {
                for(File f:popFromDeque.listFiles()) {
                    if(f.isDirectory()) {
                        deque.push(f);
                    }
                    else {
                        listFromFile.add(f.getAbsolutePath());
                    }
                }
            }
        }

        return listFromFile;

    }

    public static void main(String[] args) throws IOException {
        System.out.println(getFileTree("c:/y"));
    }
}


/*

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        return null;
    }
}
*/
