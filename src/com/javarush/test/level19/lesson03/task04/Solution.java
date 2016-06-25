package com.javarush.test.level19.lesson03.task04;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;
        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }
        public Person read() throws IOException {
            String read = scanner.nextLine();
            String[] readMass = read.split(" ");

            Date data = new Date(Integer.parseInt(readMass[5]) - 1900,
                    Integer.parseInt(readMass[4]) - 1,
                    Integer.parseInt(readMass[3]));

//            Date data2 = new Date(readMass[5] + readMass[4] + readMass[3]);

            Calendar data3 = new GregorianCalendar(Integer.parseInt(readMass[5]),
                    Integer.parseInt(readMass[4]) - 1,
                    Integer.parseInt(readMass[3]));
/*
//создаем объект типа SimpleDateFormat на основе паттерна (подробнее про формирование паттернов смотри в документации):
            SimpleDateFormat sdf = new SimpleDateFormat(“dd MM yyyy”);
//теперь выполняем через этот паттерн преобразование даты в строку:
            String currentDate = sdf.format(new Date());
//если нужно загрузить дату через строку можно использовать тот же паттерн:
            Date newDate = sdf.parse("31 12 1978");
*/
            return new Person(readMass[1], readMass[2], readMass[0], data /*data3.getTime()*/ );

        }
        public void close() throws IOException {
            scanner.close();
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("c:/c.txt");
        Scanner scanner = new Scanner(file);
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(scanner);
        System.out.println(personScannerAdapter.read());
        //System.out.println(personScannerAdapter.read());
        personScannerAdapter.close();
    }
}

/*

public class Solution {
    public static class PersonScannerAdapter  {


    }
}
*/
