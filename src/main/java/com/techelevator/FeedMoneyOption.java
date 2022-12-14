package com.techelevator;

import java.util.Scanner;

public class FeedMoneyOption {
    public static double feedMoney(double currentMoney) {
		Scanner sc =  new Scanner(System.in);
		System.out.print("Insert Money ($1s, $5s, or $10s): ");
		return currentMoney + sc.nextDouble();

	}
}
