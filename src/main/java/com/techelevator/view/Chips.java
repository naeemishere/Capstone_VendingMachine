package com.techelevator.view;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Chips extends Items{
    public Chips(double price, String itemName, String placement, String typeOfItem, int quantity) {
        super(price, itemName, placement, typeOfItem, quantity);
    }

    public static String makeNoise(){
        Items.playMusic("C:\\Users\\psoab\\Desktop\\Merit\\Pair Programming\\module-1-capstone\\Audio\\Chips.wav");
        return "Crunch Crunch, Yum!";
    }
}
