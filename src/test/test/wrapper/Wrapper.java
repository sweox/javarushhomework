package test.test.wrapper;

/**
 * Created by BELSHINA on 27.05.2016.
 */
public class Wrapper
{
    public static void main(String[] args) {
        Cat cat = new Cat();
        printNameCat(cat);
        CatWrapper catWrapper = new CatWrapper(cat);
        printNameCat(catWrapper);
    }
    static void printNameCat(Cat cat) {
        System.out.println(cat.getName());
    }
}
class Cat {
    private String name;
    public Cat() {
        this("Имя по умолчанию");
    }
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
class CatWrapper extends Cat {
    private Cat originalCat;
    public CatWrapper(Cat cat) {
        originalCat = cat;
    }
    public String getName() {
        return "Кот по имени " + originalCat.getName();
    }
    public void setName(String name) {
        originalCat.setName(name);
    }
}