package com.jav21days;

import java.util.*;

public class ComicBooks {

    public ComicBooks(){
    }
    public static void main(String [] arguments){
        HashMap quality = new HashMap();
        float price1 = 3.00F;
        quality.put("Mint", price1);
        float price2 = 2.00F;
        quality.put("Near Mint", price2);
        float price3 = 1.50F;
        quality.put("Very Fine", price3);
        float price4 = 1.00F;
        quality.put("Fine", price4);
        float price5 = 0.50F;
        quality.put("Good", price5);
        float price6 = 0.25F;
        quality.put("Poor", price6);
        //setup collection
        Comic[] comix =  new Comic[3];
        comix[0] = new Comic("Amazing Spiderman", "1A", "Very Fine", 12_000.00F);
        comix[0].setPrice( (Float) quality.get(comix[0].condition));
        comix[1] = new Comic("Incredible Hulk", "181", "Near Mint", 680.00F);
        comix[1].setPrice( (Float) quality.get(comix[1].condition));
        comix[2] = new Comic("Cerebus", "1A", "Good", 190.00F);
        comix[2].setPrice( (Float) quality.get(comix[2].condition));
        for(int i = 0; i < comix.length; i++){
            System.out.println("Title: " + comix[i].title);
            System.out.println("Issue: " + comix[i].issue);
            System.out.println("Condition: " + comix[i].condition);
            System.out.println("Price: $" + comix[i].price + "\n");
        }
    }
}
class Comic{
    String title;
    String issue;
    String condition;
    float basePrice;
    float price;

    Comic(String inTitle, String inIssue, String inCondition, float inBasePrice){
        title = inTitle;
        issue = inIssue;
        condition = inCondition;
        basePrice = inBasePrice;
    }
        void setPrice(float factor){
        price = basePrice * factor;
        }
}
