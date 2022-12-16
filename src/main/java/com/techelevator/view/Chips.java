package com.techelevator.view;

public class Chips extends Items{
    public Chips(double price, String itemName, String placement, String typeOfItem, int quantity) {
        super(price, itemName, placement, typeOfItem, quantity);
    }

    public static String makeNoise(){
        return "Crunch Crunch, Yum!";
    }

}
