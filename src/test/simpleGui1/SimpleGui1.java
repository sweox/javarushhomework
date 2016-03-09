package test.simpleGui1;

import javax.swing.*;

/**
 * Created by Belshina on 09.03.16.
 */
public class SimpleGui1
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(button);

        frame.setSize(500, 300);

        frame.setVisible(true);
    }
}
