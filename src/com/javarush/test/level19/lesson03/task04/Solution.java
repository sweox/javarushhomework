package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
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

//            Date data = new Date(Integer.parseInt(readMass[5]) - 1900,
//                    Integer.parseInt(readMass[4]) - 1,
//                    Integer.parseInt(readMass[3]));

            Calendar data = new GregorianCalendar(Integer.parseInt(readMass[5]),
                    Integer.parseInt(readMass[4]) - 1,
                    Integer.parseInt(readMass[3]));
            return new Person(readMass[1], readMass[2], readMass[0], data.getTime() );

        }
        public void close() throws IOException {
            scanner.close();
        }
    }
}

/*

public class Solution {
    public static class PersonScannerAdapter  {


    }
}
*/
