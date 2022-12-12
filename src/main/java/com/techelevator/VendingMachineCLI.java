package com.techelevator;

import com.techelevator.view.Items;
import com.techelevator.view.Menu;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String EXIT_OPTION = "Exit";
	//Exit and break was put in to stop program
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, EXIT_OPTION };



	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY,PURCHASE_MENU_OPTION_SELECT_PRODUCT,PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	LoggerFile vending = new LoggerFile();

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}



	public void run() {
		int currentMoneyProvided= 0;
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

 		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				for (Map.Entry<String,Items> str : vendingMachineItems.entrySet()) {
					System.out.println(str.getKey()+str.getValue());
				}
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				System.out.println("Current Money Provided: "+ formatter.format(currentMoneyProvided));
				String purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					// Feed Money Window
				} else if(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
					// Select Product Window
				} else if(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					// Finish Transaction Window
				}
			}
			else if (choice.equals(EXIT_OPTION)){
				break;
				//Exit program placeholder
			}
		}
	}
	Map<String,Items> vendingMachineItems  = vending.displayItems();
	//made a map to hold the items after the string[] made.
	//String itemName, String placement, String typeOfItem

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
