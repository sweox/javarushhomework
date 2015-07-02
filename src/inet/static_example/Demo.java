package inet.static_example;

/**
 * Created by Admin on 02.07.2015.
 * http://info.javarush.ru/translation/2014/04/15/10-%D0%B7%D0%B0%D0%BC%D0%B5%D1%82%D0%BE%D0%BA-%D0%BE-%D0%BC%D0%BE%D0%B4%D0%B8%D1%84%D0%B8%D0%BA%D0%B0%D1%82%D0%BE%D1%80%D0%B5-Static-%D0%B2-Java.html
 */
class Vehicle{
    public static void  kmToMiles(int km){
        System.out.println("Внутри родительского класса/статического метода");
    } }

class Car extends Vehicle{
    public static void  kmToMiles(int km){
        System.out.println("Внутри дочернего класса/статического метода ");
    } }

public class Demo{
    public static void main(String args[]){
        Vehicle v = new Car();  //Вывод "Внутри родительского класса/статического метода"
        v.kmToMiles(10);
        //================
        //Car v = new Car();    //Вывод "Внутри дочернего класса/статического метода "
        //v.kmToMiles(10);
        //================
        //new Car().kmToMiles(10);
        //new Vehicle().kmToMiles(10);
        //Car.kmToMiles(10);
        //Vehicle.kmToMiles(10);

    }}

