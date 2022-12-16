package com.techelevator;

import java.text.NumberFormat;
import java.util.Scanner;

public class FeedMoneyOption {
    public static double feedMoney(double currentMoney) {
		Scanner sc =  new Scanner(System.in);
		System.out.print("Insert Money ($1s, $5s, or $10s): ");
		return currentMoney + sc.nextDouble();

	}
	public void feedMoneyChoice(String purchaseMenuChoice, double currentMoneyProvided){
		while(purchaseMenuChoice.equals(VendingMachineCLI.getFeedMoneyOption())) {
			currentMoneyProvided = feedMoney(currentMoneyProvided);
			if(currentMoneyProvided > 20) {
				System.out.println("Can't insert money more then $20!");
				currentMoneyProvided = 0;
				break;
			}
//			purchaseMenuChoice = VendingMachineCLI.getPurchaseMenuOptionSelectProduct();
//			System.out.println("Current Money Provided: "+ formatter.format(currentMoneyProvided));
//			purchaseMenuChoice = (String) menu.getChoiceFromOptions(VendingMachineCLI.getPurchase());
			break;
		}
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
