package com.jav21days;

import java.awt.*;
import javax.swing.*;

public class TextFrame extends JFrame {
    public TextFrame(String text, String fontName){
        super("Show Font");
        setSize(425,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TextFramePanel sf = new TextFramePanel(text, fontName);
        add(sf);
        setVisible(true);
    }
    public static void main(String[] arguments){
        if(arguments.length < 2){
            System.out.println("Usage: java TextFrame msg font");
            System.exit(-1);
        }
        TextFrame frame = new TextFrame(arguments[0], arguments[1]);
    }
}

class TextFramePanel extends JPanel{
    String text;
    String fontName;

    public TextFramePanel(String text, String fontName){
        super();
        this.text = text;
        this.fontName = fontName;
    }

    @Override
    public void paintComponent(Graphics comp){
        super.paintComponent(comp);
        Graphics2D comp2d = (Graphics2D) comp;
        comp2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = new Font(fontName, Font.BOLD, 18);
        FontMetrics metric = getFontMetrics(font);
        comp2d.setFont(font);
        int x = (getSize().width = metric.stringWidth(text))/2;
        int y = getSize().height / 2;
        comp2d.drawString(text,x,y);

            }

}