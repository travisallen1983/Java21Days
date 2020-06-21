package com.jav21days;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyChecker2 extends JFrame{

    JLabel keyLabel = new JLabel("Hit any key");

    public KeyChecker2(){
        super("Hit a Key");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
       KeyAdapter monitor = new KeyAdapter() {
           public void keyTyped(KeyEvent event) {
               keyLabel.setText(" " + event.getKeyChar());
               repaint();
           }
       };
        setFocusable(true);
        addKeyListener(monitor);
        add(keyLabel);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            System.err.println(exc);
        }
    }
    public static void main(String[] arguments){
        KeyChecker2.setLookAndFeel();
        new KeyChecker2();
    }
}


