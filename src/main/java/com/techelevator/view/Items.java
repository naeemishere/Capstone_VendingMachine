package com.techelevator.view;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Items {
    private double price;
    private String itemName;
    private String placement;
    private String typeOfItem;
    public int amountOfItems=5;

    public void setAmountOfItems(int amountOfItems) {
        this.amountOfItems = amountOfItems;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmountOfItems() {
        return amountOfItems;
    }

    public double getPrice() {
        return price;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPlacement() {
        return placement;
    }

    public String getTypeOfItem() {
        return typeOfItem;
    }

    @Override
    public String toString() {
        //String.format("%,.2f", amount));
        return  "|"+itemName+"|"+ String.format("%.2f",price)+"|"+ typeOfItem+"|Q:"+amountOfItems;

    }

    public Items(double price, String itemName, String placement, String typeOfItem, int quantity) {
        this.amountOfItems = quantity;
        this.price = price;
        this.itemName = itemName;
        this.placement = placement;
        this.typeOfItem = typeOfItem;
    }


    public static String makeSound(String placement){
        String purchaseWords = "";
        if(placement.startsWith("A")){
            return Chips.makeNoise();
        } else if (placement.startsWith("B")) {
            return Candy.makeNoise();
        }else if (placement.startsWith("C")){
            return Soda.makeNoise();
        } else if (placement.startsWith("D")) {
            return Gum.makeNoise();
        }
        return purchaseWords;
    }

    public static void playMusic(String filePath) {

        try {
            File musicPath = new File(filePath);

            if(musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.out.println("Can't find file");
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }


}
