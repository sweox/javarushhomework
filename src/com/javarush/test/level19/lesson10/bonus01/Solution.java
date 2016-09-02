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
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
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

//            primo(list1, list2, 0);
            System.out.println(list1);
            System.out.println(list2);

            if (list1.size() >= list2.size()) {
                for (int i = 0; i < list2.size(); i++) {
                    if (list1.get(i).equals(list2.get(i))) {
                        lines.add(new LineItem(Type.SAME, list1.get(i)));
                    } else if (list1.get(i + 1).equals(list2.get(i))) {
                        lines.add(new LineItem(Type.REMOVED, list1.get(i + 1)));
                        //lines.add(new LineItem(Type.SAME, list1.get(i)));
                    } //else if (!list1.get(1).equals(list2.get(i + 1)))
                      //  lines.add(new LineItem(Type.REMOVED, list1.get(i)));

                }
            }
            else {
                for (int i = 0; i < list2.size(); i++) {
                    if (list2.get(i).equals(list1.get(i))) {
                        lines.add(new LineItem(Type.SAME, list2.get(i)));
                    }
                    else if (list2.get(i).equals(list1.get(i + 1))) {
                        lines.add(new LineItem(Type.REMOVED, list2.get(i)));
                        lines.add(new LineItem(Type.SAME, list2.get(i)));
                    }
                    else if (!list2.get(i).equals(list2.get(i + 1))) {
                        lines.add(new LineItem(Type.ADDED, list2.get(i)));
                        lines.add(new LineItem(Type.REMOVED, list2.get(i)));

                    }
                }
            }

            for (LineItem l : lines) {
                System.out.println(l.type + " " + l.line);
            }
        }
        catch (IOException e) {}
    }

//    static void primo(ArrayList<String> list1, ArrayList<String> list2, int start) {
//        if (start < list2.size())
//        {
//            for (int i = start; i < list2.size(); i++)
//            {
//                if (list1.get(i).equals(list2.get(i)))
//                {
//                    lines.add(new LineItem(Type.SAME, list1.get(i)));
//                } else if (list1.get(i).equals(list2.get(i + 1)))
//                {
//                    lines.add(new LineItem(Type.ADDED, list2.get(i + 1)));
//                    primo(list1, list2, start + i + 1);
//                }
//
//            }
//        }
//    }

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
