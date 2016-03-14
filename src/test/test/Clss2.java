package test.test;


class Vehicle{
    public static void  kmToMiles(int km){
        System.out.println("Внутри родительского класса/статического метода");
        Car.kmToMiles(km);
    } }

class Car extends Vehicle{
    public static void  kmToMiles(int km){
        //super.kmToMiles(10);
        System.out.println("Внутри дочернего класса/статического метода ");
    } }



public class Clss2
{
    public static void main(String args[])
    {
        Vehicle v = new Car();
        v.kmToMiles(10);

    }
}
