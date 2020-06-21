package com.jav21days;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;

public class DiceRoller extends JFrame implements ActionListener, PropertyChangeListener {
    //the table for dice-roll results
    JTextField[] total = new JTextField[16];
    //The "roll" button
    JButton roll;
    //The number of times to roll
    JTextField quantity;
    //The swing worker
    DiceWorker worker;

    public DiceRoller(){
        super("Dice Roller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850,145);

        //setup top row
        JPanel topPane = new JPanel();
        GridLayout paneGrid = new GridLayout(1,16);
        topPane.setLayout(paneGrid);
        for(int i = 0; i < 16; i++){
            //create a textfield and label
            total[i] = new JTextField("0", 4);
            JLabel label = new JLabel((i + 3) + ": ");
            //create this cell in the grid
            JPanel cell =  new JPanel();
            cell.add(label);
            cell.add(total[i]);
            topPane.add(cell);
        }

        //set up bottom row

        JPanel bottomPane = new JPanel();
        JLabel quantityLabel = new JLabel("Times to Roll: ");
        quantity = new JTextField("0", 5);
        roll = new JButton("Roll");
        roll.addActionListener(this);
        bottomPane.add(quantityLabel);
        bottomPane.add(quantity);
        bottomPane.add(roll);

        //set up frame
        GridLayout frameGrid = new GridLayout(2,1);
        setLayout(frameGrid);
        add(topPane);
        add(bottomPane);

        setVisible(true);

    }
    //Respond when the roll button is clicked
    @Override
    public void actionPerformed(ActionEvent event){
        int timesToRoll;
        try{
            //turn off the button
            timesToRoll = Integer.parseInt(quantity.getText());
            roll.setEnabled(false);
            // set up the worker that will roll the dice
            worker = new DiceWorker(timesToRoll);
            //add a listener that monitors the worker
            worker.addPropertyChangeListener(this);
            //Start the worker
            worker.execute();
        }catch(NumberFormatException nfe){
            System.out.println(nfe.getMessage());
        }
    }
    //Respond when the worker's task is complete
    @Override
    public void propertyChange(PropertyChangeEvent event){
        try{
            //get the worker's dice roll results
            int[] result = (int[]) worker.get();
            //store the results in text fields
            for(int i = 0; i < result.length; i++){
                total[i].setText(" " + result[i]);
            }
        }catch(Exception exc){
            System.out.println(exc);
        }
    }
    private static void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        }catch(Exception exc){
            //ignore exception
        }
    }
    public static void main(String[] arguments){
        DiceRoller.setLookAndFeel();
        DiceRoller app = new DiceRoller();
    }
}
