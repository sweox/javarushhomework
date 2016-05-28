package test.test.solution_18_08_05;

import java.util.ArrayList;
import java.util.List;

//package com.javarush.test.level18.lesson08.task05;


/* Таблица
Измените класс TableInterfaceWrapper так, чтобы он стал Wrapper-ом для ATableInterface.
Метод setModel должен вывести в консоль количество элементов в новом листе перед обновлением модели
Метод getHeaderText должен возвращать текст в верхнем регистре - используйте метод toUpperCase()
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {
        private ATableInterface originalATableInterface;
        public TableInterfaceWrapper(ATableInterface originalATableInterface) {
            this.originalATableInterface = originalATableInterface;
        }
        public void setModel(List rows) {
            System.out.println(rows.size());
            originalATableInterface.setModel(rows);
        }
        public String getHeaderText() {
            return originalATableInterface.getHeaderText().toUpperCase();
        }
        public void setHeaderText(String newHeaderText) {
            originalATableInterface.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }



}
class ATable implements Solution.ATableInterface {
    String headerText;
    //        public ATable (String headerText) {
//            this.headerText = headerText;
//        }
    @Override
    public void setModel(List rows)
    {
        System.out.println(rows);
    }

    @Override
    public String getHeaderText()
    {
        return headerText;
    }

    @Override
    public void setHeaderText(String newHeaderText)
    {
        headerText = newHeaderText;
    }
}


class test
{
    public static void main(String[] args)
    {
        List list = new ArrayList();
        list.add(4);
        list.add(5);
        list.add(47);
        list.add(4);
        Solution.ATableInterface a = new ATable();
        Solution.TableInterfaceWrapper wr = new Solution().new TableInterfaceWrapper(a);
        wr.setModel(list);
        wr.setHeaderText("hello");
        System.out.println(wr.getHeaderText());
    }
}
