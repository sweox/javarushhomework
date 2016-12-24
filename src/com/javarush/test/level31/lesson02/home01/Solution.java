package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        String path = args[0] ;
        String resultFileAbsolutePath = args[1] ;
        File filePath = new File(path);

        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> listForSort = new ArrayList<>();

        methodForFolder(map, filePath, resultFileAbsolutePath);

        listForSort.addAll(map.keySet());
        Collections.sort(listForSort);


        File fileResultFileAbsolutePath = new File(resultFileAbsolutePath);
        File allFilesContent = new File(fileResultFileAbsolutePath.getParent()
                + "/allFilesContent.txt");
        fileResultFileAbsolutePath.renameTo(allFilesContent);



        FileInputStream inputStream;
        FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent);
        for(String s:listForSort) {
            inputStream = new FileInputStream(map.get(s));
            while(inputStream.available() > 0) {
                fileOutputStream.write(inputStream.read());
            }
            fileOutputStream.write('\n');
            inputStream.close();
        }

        fileOutputStream.close();


    }
    public static void methodForFolder(HashMap map, File filePath, String resultFileAbsolutePath) {
        for(File fil: filePath.listFiles()) {
            if(fil.isFile() && !fil.getName().equals(new File(resultFileAbsolutePath).getName())) {
                if(fil.length() > 50) {
                    fil.delete();
                }
                else {
                    map.put(fil.getName(), fil.getAbsolutePath());
                }
            }
            else if (fil.isDirectory()) {
                methodForFolder(map, fil, resultFileAbsolutePath);
                fil.delete();
            }

        }
    }
}

/*
public class Solution {
    public static void main(String[] args) throws IOException {

    }
}
*/
