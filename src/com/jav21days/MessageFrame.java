package com.jav21days;

import javax.swing.*;

public class MessageFrame extends JFrame {

    public MessageFrame(){
        super("Message");
        setSize(380,120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MessagePanel mPanel = new MessagePanel();
        add(mPanel);
        setVisible(true);
    }
    private static void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel(
                    "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        }catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }
    public static void main(String[] arguments){
        MessageFrame.setLookAndFeel();
        MessageFrame frame = new MessageFrame();
    }
}
