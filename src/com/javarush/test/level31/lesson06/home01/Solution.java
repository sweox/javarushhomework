package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    public static Map<ZipEntry, ByteArrayOutputStream> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        File fileName = /*new File(args[0])*/ new File("c:/1/result.mp3");
        File zip = /*new File(args[1])*/ new File("C:/1/pathToTest/test.zip");

        readZip(zip);
        writeZip(fileName, zip);
    }

    public static void readZip(File zip) {
        ZipEntry zipEntryTmp;

        try(FileInputStream fileInputStream = new FileInputStream(zip);
            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream)) {
            while((zipEntryTmp = zipInputStream.getNextEntry()) != null) {

//                System.out.println(zipEntryTmp);

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] tmpByte = new byte[1000];
                int count;
                while((count = zipInputStream.read(tmpByte)) > 0) {
                    byteArrayOutputStream.write(tmpByte, 0, count);
                }
//                System.out.println(byteArrayOutputStream.toString());

                map.put(zipEntryTmp, byteArrayOutputStream);
            }

            zipInputStream.closeEntry();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeZip(File fileName, File zip) {
        try(ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zip));
            FileInputStream fileInputStream = new FileInputStream(fileName)) {
            for(Map.Entry<ZipEntry, ByteArrayOutputStream> f:map.entrySet()) {
                ZipEntry tmp = new ZipEntry(f.getKey().getName());
                System.out.println(f.getKey());
                zipOutputStream.putNextEntry(tmp);
                zipOutputStream.write(f.getValue().toByteArray());
            }

            zipOutputStream.putNextEntry(new ZipEntry(fileName.getName()));
            byte[] tmpForNewFile = new byte[fileInputStream.available()];
            while(fileInputStream.available() > 0) {
                fileInputStream.read(tmpForNewFile);
            }
            zipOutputStream.write(tmpForNewFile);

            zipOutputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
