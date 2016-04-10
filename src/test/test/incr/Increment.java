package test.test.incr;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

/**
 * Created by BELSHINA on 10.04.2016.
 */
public class Increment
{
    public static void main(String[] args)
    {
        int i = 5;
        System.out.println(i++ + i++);
        System.out.println(i);
        Map<String, Charset> allCharset = Charset.availableCharsets();
        Set<String> charsetName = allCharset.keySet();
        System.out.println(charsetName);
        System.out.println(charsetName.size());
    }
}
