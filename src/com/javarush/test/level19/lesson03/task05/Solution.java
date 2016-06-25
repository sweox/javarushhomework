package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        public String getCountryCode() {
            String countrName = "";
            for(Map.Entry<String, String> i:countries.entrySet()) {
                if(i.getValue().equals(customer.getCountryName())) {
                    countrName = i.getKey();
                }
            }
            return countrName;
        }

        public String getCompany() {
            return customer.getCompanyName();
        }

        public String getContactFirstName() {
            String[] mas = contact.getName().split(" ");
            return mas[1];
        }

        public String getContactLastName() {
            String[] mas = contact.getName().split(" ");
            return mas[0].substring(0, mas[0].length() - 1);
        }

        public String getDialString() {
            /*String conNumber = contact.getPhoneNumber();
            return "callto://" + conNumber.substring(0, 3) + conNumber.substring(4, 7) +
                    conNumber.substring(8, 11) + conNumber.substring(12, 14) +
                    conNumber.substring(15, 17);*/
            String conNumber = contact.getPhoneNumber();
            return "callto://" + conNumber.replaceAll("[()-]", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
    /*
    public static void main(String[] args)
    {
        class clCustomer implements Customer {
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }
            public String getCountryName() {
                return "Ukraine";
            }
        }
        class clContact implements Contact {
            public String getName() {
                return "Ivanov, Ivan";
            }
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        }
        DataAdapter dataAdapter = new DataAdapter(new clCustomer(), new clContact());
        System.out.println(dataAdapter.getCountryCode());
        System.out.println(dataAdapter.getCompany());
        System.out.println(dataAdapter.getContactFirstName());
        System.out.println(dataAdapter.getContactLastName());
        System.out.println(dataAdapter.getDialString());
    }
    */
}

/*

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    public static class DataAdapter {
        public DataAdapter(Customer customer, Contact contact) {
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
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
