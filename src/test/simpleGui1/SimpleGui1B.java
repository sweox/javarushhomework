package test.simpleGui1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Belshina on 09.03.16.
 */
public class SimpleGui1B implements ActionListener
{
    JButton button;
    public static void main(String[] args)
    {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();



    }

    public void go() {
        JFrame frame = new JFrame();
        JButton button = new JButton("click me");

        button.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(500, 300);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        button.setText("I've been clicked!");
    }
}
