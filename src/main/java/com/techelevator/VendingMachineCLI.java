package com.techelevator;

import com.techelevator.view.Items;
import com.techelevator.view.Menu;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;


public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT_OPTION = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT_OPTION };
	//added a exit option



	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY,PURCHASE_MENU_OPTION_SELECT_PRODUCT,PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	Scanner userInput = new Scanner(System.in);

	LoggerFile vending = new LoggerFile();

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}



	public void run() {
		double currentMoneyProvided= 0;



		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				for (Map.Entry<String,Items> str : vendingMachineItems.entrySet()) {
					System.out.println(str.getKey()+str.getValue());
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				System.out.println("Current Money Provided: "+ formatter.format(currentMoneyProvided));
				String purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				if (purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					// Feed Money Window
					currentMoneyProvided = feedMoney(currentMoneyProvided);
					System.out.println("Current Money Provided: "+ formatter.format(currentMoneyProvided));
					purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

					// User Selects Feed Money
					if(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

						// If already inside the Feed Money Menu and continue from here on:

						// If user selects Feed Money
						while(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
							currentMoneyProvided = feedMoney(currentMoneyProvided);
							if(currentMoneyProvided > 20) {
								System.out.println("Can't insert money more then $20!");
								currentMoneyProvided = 0;
								break;
							}
							purchaseMenuChoice = PURCHASE_MENU_OPTION_SELECT_PRODUCT;
							System.out.println("Current Money Provided: "+ formatter.format(currentMoneyProvided));
							purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
						}
					}

					// User selects Select Product
					if(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

						// If user select Product Window
						while(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
							for (Map.Entry<String,Items> str : vendingMachineItems.entrySet()) {
								System.out.println(str.getKey()+str.getValue());
							}
							System.out.print("Enter Selection Number: ");
							String option = userInput.nextLine();

							// Here Check if the currently provided money is > 0
							if(currentMoneyProvided <= 0) {
								System.out.println("Balance: $0.00, Enter Money to make a purchase! :)");
								purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
							}

							// Checking if user selected item exists inside vending machine
							if(vendingMachineItems.containsKey(option)){
								System.out.println("It works!");
								// This is Where we need a functionality of subtracting currently provided money and quantity == , dispense()
								Items vending = vendingMachineItems.get(option);
								// Check if user doesn't have enough money to make a purchase
								int vendingItem = vending.getAmountOfItems() - 1;
								double itemPrice = vending.getPrice();
								if(currentMoneyProvided < itemPrice) {
									System.out.println("Not enough money to purchase the selected item! Make another Selection or Feed Money!");
									purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
								} else {
									vending.setAmountOfItems(vendingItem);
									currentMoneyProvided = currentMoneyProvided - itemPrice;
								}

								// Print specific make noise sound method
								System.out.println(makeSound(option));
								System.out.println("Remaining Balance: "+ formatter.format(currentMoneyProvided));

							} else {
								System.out.println("Key Not found!");
							}
							purchaseMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
						}

					}
					// User Selects Finish Transaction (Its own class)
					if(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						// Method to return remaining balance into coins
						balanceToZero(currentMoneyProvided);
						System.out.println("Thank you for making the purchase, Enjoy! :)");
						continue;
					}


				} else if(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
					for (Map.Entry<String,Items> str : vendingMachineItems.entrySet()) {
						System.out.println(str.getKey()+str.getValue());
					}

				} else if(purchaseMenuChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					// Finish Transaction Window
					break;
				}
			} else {
				break;
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
	public static double feedMoney(double currentMoney) {
		Scanner sc =  new Scanner(System.in);
		System.out.print("Insert Money ($1s, $5s, or $10s): ");
		return currentMoney + sc.nextDouble();
	}

	public String makeSound(String placement){
		String purchaseWords = "";
		if(placement.startsWith("A")){
			purchaseWords = "\nCrunch Crunch, Yum!";
		} else if (placement.startsWith("B")) {
			purchaseWords = "\nMunch Munch, Yum!";
		}else if (placement.startsWith("C")){
			purchaseWords = "\nGlug Glug, Yum!";
		} else if (placement.startsWith("D")) {
			purchaseWords = "\nChew Chew, Yum!";
		}
		return purchaseWords;
	}

	public void balanceToZero(double amount) {
		double convert = amount * 100;
		int quarters = (int) (convert / 25);
		int tempAmount = (int) (convert % 25);
		int dimes = tempAmount / 10;
		int tempAmount2 = tempAmount % 10;
		int nickles = tempAmount2 / 5;
		int tempAmount3 = tempAmount2 % 5;

		System.out.println("Return change: Quarters Dispensed: "+quarters+" Dimes Dispensed: "+dimes+" Nickles Dispensed: "+nickles);
	}

}
