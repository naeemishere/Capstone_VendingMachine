package com.techelevator;

import com.techelevator.view.Items;

import java.util.Map;

public class SelectProductOption {

    public static Map<String, Items> selectProduct(){
        LoggerFile vending = new LoggerFile();
        Map<String,Items> vendingMachineItems  = vending.displayItems();
        vendingMachineItems.putAll(vendingMachineItems);
        return vendingMachineItems;
    }

}
