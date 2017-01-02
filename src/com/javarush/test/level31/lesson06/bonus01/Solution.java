package com.javarush.test.level31.lesson06.bonus01;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов
fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав
его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*String[] tmp = new String[5];
        tmp[0] = "C:/2/result.mp3";
        tmp[1] = "C:/1/pathToTest/test.zip.003";
        tmp[2] = "C:/1/pathToTest/test.zip.001";
        tmp[3] = "C:/1/pathToTest/test.zip.004";
        tmp[4] = "C:/1/pathToTest/test.zip.002";
        args = tmp;*/

        List<String> listPart = new ArrayList<>();
        File resultFileName = new File(args[0]) ;

        String[] argsCopy = new String[args.length - 1];
        System.arraycopy(args, 1, argsCopy, 0, argsCopy.length);
        Collections.addAll(listPart, argsCopy);
        Collections.sort(listPart);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        for(String s:listPart) {
            FileInputStream fileInputStream = new FileInputStream(new File(s));
            while(fileInputStream.available() > 0) {
                byte[] b = new byte[fileInputStream.available()];
                fileInputStream.read(b);
                byteArrayOutputStream.write(b);
            }
        }

        ZipInputStream zipInputStream = new ZipInputStream(
                new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        ZipEntry zipEntryFromArchive = zipInputStream.getNextEntry();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte [] tmpByte = new byte[1024 * 1024];
        int count;

        while((count = zipInputStream.read(tmpByte)) > 0) {
            bos.write(tmpByte, 0, count);
        }

        FileOutputStream fos = new FileOutputStream(resultFileName);
        fos.write(bos.toByteArray());
        fos.close();

        zipInputStream.closeEntry();
    }
}


/*
public class Solution {
    public static void main(String[] args) {
    }
}
*/
