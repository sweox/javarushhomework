package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям
модификатор transient.
*/

public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Person person = new Person("Uladzimir", "Rajzhanski", "Belarus", Sex.MALE);
        System.out.println(person.firstName);
        System.out.println(person.lastName);
        System.out.println(person.fullName);
        System.out.println(person.greetingString);
        System.out.println(person.country);
        System.out.println(person.sex);
        System.out.println(person.outputStream);
        System.out.println(person.logger);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:/77.txt"));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:/77.txt"));
        out.writeObject(person);
        Person person1 = new Person("Uladzimir1", "Rajzhanski1", "Belarus1", Sex.FEMALE);
        System.out.println("++++++++++++++++++++++");
        System.out.println(person1.firstName);
        System.out.println(person1.lastName);
        System.out.println(person1.fullName);
        System.out.println(person1.greetingString);
        System.out.println(person1.country);
        System.out.println(person1.sex);
        System.out.println(person1.outputStream);
        System.out.println(person1.logger);
        person1 = (Person)in.readObject();
        System.out.println("++++++++++++++++++++++");
        System.out.println(person1.firstName);
        System.out.println(person1.lastName);
        System.out.println(person1.fullName);
        System.out.println(person1.greetingString);
        System.out.println(person1.country);
        System.out.println(person1.sex);
        System.out.println(person1.outputStream);
        System.out.println(person1.logger);
        System.out.println("_________________________");
        Person person2 = new Person(person1.firstName, person1.lastName, person1.country,
                person1.sex);
        System.out.println(person2.firstName);
        System.out.println(person2.lastName);
        System.out.println(person2.fullName);
        System.out.println(person2.greetingString);
        System.out.println(person2.country);
        System.out.println(person2.sex);
        System.out.println(person2.outputStream);
        System.out.println(person2.logger);
    }
}

/*

public class Solution {

    public static class Person {
        String firstName;
        String lastName;
        String fullName;
        final String greetingString;
        String country;
        Sex sex;
        PrintStream outputStream;
        Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
}
*/
