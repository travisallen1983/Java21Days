package com.jav21days;

import javax.swing.*;

public class FormatFrame2 extends JFrame {
    String[] formats = {"Atom", "RSS 0.92", "RSS 1.0", "RSS 2.0"};
    JComboBox<String> formatBox = new JComboBox<>(formats);

    public FormatFrame2(){
        super("Choose a Format");
        setSize(220,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        JLabel formatLabel = new JLabel("Output formats:");
        pane.add(formatLabel);
        pane.add(formatBox);
        add(pane);
        setVisible(true);

    }
    public static void setLookAndFeel(){
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        }catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }

    public static void main(String[] arguments){
        FormatFrame.setLookAndFeel();
        FormatFrame2 ff = new FormatFrame2();
    }
}
