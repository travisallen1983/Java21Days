package com.jav21days;

import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class FeedInfo extends JFrame {
    private final JLabel nameLabel = new JLabel("Name: ", SwingConstants.RIGHT);
    private final JTextField name;
    private final JLabel urlLabel = new JLabel("Url: ", SwingConstants.RIGHT);
    private final JTextField url;
    private final JLabel typeLabel = new JLabel("Type: ", SwingConstants.RIGHT);
    private final JTextField type;

    public FeedInfo(){
        super("Feed information");
        setSize(400, 145);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        //Site name
        String response1 = JOptionPane.showInputDialog(null, "Enter the site name:");
        name = new JTextField(response1, 20);
        //Site address
        String response2 = JOptionPane.showInputDialog(null, "Enter the site address:");
        url = new JTextField(response2, 20);
        //Site type
        String[] choices = {"Personal", "Commercial", "Unknown"};
        int response3 = JOptionPane.showOptionDialog(null, "What type of site is it?",
                                                        "Site type", 0, JOptionPane.QUESTION_MESSAGE,
                                                            null, choices, choices[0]);
        type = new JTextField(choices[response3], 20);

        setLayout(new GridLayout(3,2));
        add(nameLabel);
        add(name);
        add(urlLabel);
        add(url);
        add(typeLabel);
        add(type);
        setLookAndFeel();
        setVisible(true);
    }
    private void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel(
                    "javax.swing.plaf.nimbus.NimbusLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        }catch(Exception e){
            System.err.println("Couldn't use the system " + "look and feel:" + e);
        }
    }
    public static void main(String[] arguments){
        FeedInfo frame = new FeedInfo();
    }

}
