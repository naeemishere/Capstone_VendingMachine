package com.techelevator;

import com.techelevator.view.Items;
import com.techelevator.view.Menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
	//added a exit option
	private static final String EXIT_OPTION = "Exit";


	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}



	public void run() {
		restock();

	//Items list = new Items();
		List <String> vendingList = Items.displayItems();
 		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				for (Map.Entry<String,Items> str : vendingMachineItems.entrySet()) {
					System.out.println(str.getKey()+str.getValue());
				}
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}
	}
	Map<String,Items> vendingMachineItems  = new HashMap<>();
	//made a map to hold the items after the string[] made.
	//String itemName, String placement, String typeOfItem
	public void restock(){
		//restock method because everytime the program runs we need to restock it to 5
		for (String str:Items.displayItems()) {
			String[] eachItem =str.split("\\|");

			Items vendingItem = new Items(Double.parseDouble(eachItem[2]),eachItem[1],eachItem[0],eachItem[3] );
			vendingMachineItems.put(vendingItem.getPlacement(), vendingItem);
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
