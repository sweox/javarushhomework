package test.test.strBuild;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by BELSHINA on 25.05.2016.
 */
public class StrBuild
{
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Lena").append('\n');

        String data = sb.toString();

        InputStream in = new ByteInputStream(data.getBytes(), data.length());
        System.setIn(in);
        readAndPrint();
    }
    public static void readAndPrint() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        while(true) {
            String line = reader.readLine();
            if (line == null) break;
            System.out.println(line);
        }
        reader.close();
        isr.close();
    }
}
