package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Items {
    public static List <String> displayItems() {
        String inputFile = "vendingmachine.csv";
        File file = new File(inputFile);
        List<String> itemLine = new ArrayList<>();
        try (Scanner vendingItems = new Scanner(file)) {
            while (vendingItems.hasNextLine()) {
                itemLine.add(vendingItems.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
//        for (String str : itemLine) {
//            System.out.println(str);
//        }
	return itemLine;
    }
}
