package test.chap14.pond;

/**
 * Created by Belshina on 10.03.16.
 */
import java.io.*;
public class Pond implements Serializable
{
    transient private Duck duck = new Duck();
    int _jfsdlfkjsdlfjj = 50;

    public static void main(String[] args)
    {
        Pond myPond = new Pond();
        try {
            FileOutputStream fs = new FileOutputStream("Pond.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(myPond);
            os.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public class Duck  {}
}

