package test.test.generi;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 01.04.2016.
 */
public class Generi
{
    public static void main(String[] args)
    {
        List list = new LinkedList(Arrays.asList("First", 10));

//        list.add("First");
//        list.add(10);
        List<String> list2 = list;
        System.out.println(list2);
//        for(Iterator<String> l = list2.iterator(); l.hasNext(); ) {
//            System.out.println(l.next());
//        }

        List<String> list1 = new LinkedList<>();
        list.add("First");
        list.add(10);
        List list3 = list1;
        for(Iterator<String> iterItm = list3.iterator(); iterItm.hasNext(); ) {
            System.out.println(iterItm.next());
        }
    }

}
