package com.javarush.test.level19.lesson10.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
//==============================================================
строка1        строка1            SAME строка1
строка2        строка3            REMOVED строка2
строка3        строка5            SAME строка3
строка4        строка0            REMOVED строка4
строка5        строка1            SAME строка5
строка1        строка3            ADDED строка0
строка2        строка5            SAME строка1
строка3        строка4            REMOVED строка2
строка4                           SAME строка3
строка5                           ADDED строка5
                                  SAME строка4
                                  REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        String fileName1 = "";
        String fileName2 = "";
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            reader.close();

            readFile(fileName1, list1);
            readFile(fileName2, list2);

            int i = 0;
            int j = 0;
            while (i < list1.size() && j < list2.size()) {

                if (list1.get(i).equals(list2.get(j))) {
                    lines.add(new LineItem(Type.SAME, list1.get(i)));
                    i++;
                    j++;
                }

                else if (list1.size() > (i + 1) && list1.get(i + 1).equals(list2.get(j))) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    i++;
                }
                else if (list2.size() > (j + 1) && list2.get(j + 1).equals(list1.get(i))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(j)));
                    j++;
                }


            }

            if (i < list1.size()) {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
            }
            if (j < list2.size()) {
                lines.add(new LineItem(Type.ADDED, list2.get(j)));
            }


        }
        catch (Exception e) {}
        //finally
        //{
            for (LineItem l : lines) {
                System.out.println(l.type + " " + l.line);
            }
        //}
    }


    static void readFile(String fileName, ArrayList<String> arrayList)  throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (reader.ready()) {
            arrayList.add(reader.readLine());
        }
        reader.close();
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
