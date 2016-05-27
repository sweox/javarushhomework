package test.test.wrapper;

/**
 * Created by BELSHINA on 27.05.2016.
 */
public class Wrapper
{
    public static void main(String[] args) {
        Cat cat = new Cat("Петька");
        printNameCat(cat);
        CatWrapper catWrapper = new CatWrapper(cat);
        printNameCatWrapper(catWrapper);
    }
    static void printNameCat(Cat cat) {
        System.out.println(cat.getName());
    }
    static void printNameCatWrapper(CatWrapper catWrapper) {
        System.out.println(catWrapper.getName());
    }
}
class Cat {
    private String name;
    public Cat(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class CatWrapper {
    private Cat originalCat;
    CatWrapper(Cat cat) {
        originalCat = cat;
    }
    String getName() {
        return "Кот по имени " + originalCat.getName();
    }
    void setName(String name) {
        originalCat.setName(name);
    }
}