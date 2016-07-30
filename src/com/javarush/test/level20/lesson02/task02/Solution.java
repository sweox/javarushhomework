package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
//            User user1 = new User();
//            user1.setFirstName("Uladzimir");
//            user1.setLastName("Razhanski");
//            user1.setBirthDate(new SimpleDateFormat("dd MM yyyy").parse("23 07 2016"));
//            user1.setMale(true);
//            user1.setCountry(User.Country.RUSSIA);
//
//            User user2 = new User();
//
//            javaRush.users.add(user1);
//            //javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
//            for(User us1 : javaRush.users) {
//                for(User us2 : loadedObject.users) {
//                   if(us1 != null && us2 != null)
//                   {
//                       System.out.println(us1.getBirthDate().equals(us2.getBirthDate()) &&
//                               us1.getFirstName().equals(us2.getFirstName()) &&
//                               us1.getLastName().equals(us2.getLastName()) &&
//                               us1.isMale() == us2.isMale());
//                   }
//                }
//            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            for(User user : users) {
                if(user != null)
                {
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    if(user.getFirstName() != null)
                        printWriter.println(user.getFirstName());
                    if(user.getLastName() != null)
                        printWriter.println(user.getLastName());
                    if(user.getBirthDate() != null)
                        printWriter.println(user.getBirthDate().getTime());

                    if(user.getCountry() != null)
                        printWriter.println(user.getCountry());
                    if(user.getFirstName() != null && user.getLastName() != null
                    && user.getBirthDate() != null && user.getCountry() != null)
                        printWriter.println(user.isMale());
                    printWriter.flush();
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String tmp;
            while((tmp = reader.readLine()) != null) {

                    User user = new User();
                    user.setFirstName(tmp);
                    user.setLastName(reader.readLine());
                    user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    user.setCountry(User.Country.valueOf(reader.readLine()));
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    users.add(user);

            }
        }
    }
}

/*

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод

            }
        }
    }
}
*/
