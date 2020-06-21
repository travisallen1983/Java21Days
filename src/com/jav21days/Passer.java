package com.jav21days;

public class Passer {
    void toUppercase(String [] text){
        for(int i =0; i < text.length; i++){
            text[i] = text[i].toUpperCase();
        }
    }
    public static void main(String [] arguments){
        Passer passer = new Passer();
        passer.toUppercase(arguments);
        for(int i = 0; i < arguments.length; i++){
            System.out.print(arguments[i] + " ");
        }
        System.out.println();
    }
}
