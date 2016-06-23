package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.*;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static class IncomeDataAdapter implements  Customer, Contact {
        private IncomeData incomeData;
        public IncomeDataAdapter(IncomeData incomeData) {
            this.incomeData = incomeData;
        }
        public String getCompanyName() {
            return incomeData.getCompany();
        }
        public String getCountryName() {
            String tmpCountryName = "";
            for(Map.Entry<String, String> c:countries.entrySet()) {
                if(c.getKey().equals(incomeData.getCountryCode())) {
                    tmpCountryName = c.getValue();
                }
            }
            return tmpCountryName;
        }
        public String getName() {
            return incomeData.getContactLastName() + ", " + incomeData.getContactFirstName();
        }
        public String getPhoneNumber() {
//            List<Character> list = new ArrayList<>();
//            int tmpPhoneCode = incomeData.getCountryPhoneCode();
//            Integer tmpPhoneNumber = incomeData.getPhoneNumber();
//            char[] numberToChar = tmpPhoneNumber.toString().toCharArray();
//            for(int i = 0; i < numberToChar.length; i++) {
//                list.add(numberToChar[i]);
//            }
//            if(list.size() < 10) {
//                while(list.size() < 10) {
//                    list.add(0, '0');
//                }
//            }
//            return "+" + tmpPhoneCode + "(" + list.get(0) + list.get(1)
//                    + list.get(2) + ")" + list.get(3) + list.get(4) +list.get(5)
//                    + "-" + list.get(6) + list.get(7) + "-" + list.get(8) + list.get(9);
            int i = incomeData.getCountryPhoneCode();
            String s = String.valueOf(incomeData.getPhoneNumber());
            if (s.length() < 10) {
                while(s.length() < 10) {
                    s = 0 + s;
                }
            }
            return "+" + i + "(" + s.substring(0, 3) + ")" + s.substring(3, 6)
                    + "-" + s.substring(6, 8) + "-" + s.substring(8, 10);
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }

    public static void main(String[] args)
    {
        IncomeDataAdapter in = new IncomeDataAdapter(new One());
        System.out.println(in.getCompanyName());
        System.out.println(in.getCountryName());
        System.out.println(in.getName());
        System.out.println(in.getPhoneNumber());
    }
    static class One implements IncomeData {
        @Override
        public String getCountryCode()
        {
            return "UA";
        }

        @Override
        public String getCompany()
        {
            return "JavaRush Ltd.";
        }

        @Override
        public String getContactFirstName()
        {
            return "Ivan";
        }

        @Override
        public String getContactLastName()
        {
            return "Ivanov";
        }

        @Override
        public int getCountryPhoneCode()
        {
            return 38;
        }

        @Override
        public int getPhoneNumber()
        {
            return 501234567;
        }
    }
}


/*

import java.util.HashMap;
        import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    public static class IncomeDataAdapter {
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}

*/
