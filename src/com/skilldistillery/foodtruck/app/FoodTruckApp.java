package com.skilldistillery.foodtruck.app;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	java.util.Scanner sc = new java.util.Scanner(System.in);

	private FoodTruck[] FleetTrucks = new FoodTruck[5];
	private String name;

	public static void main(String[] args) {
		// that is the only static allowed in the project.
		System.out.println("Welcome to the food truck app where you can store information about food trucks"+
		"then compare them."); 
		FoodTruckApp fTA = new FoodTruckApp();
		fTA.TruckData();
		fTA.MenuChoices();
	}

	public void TruckData() {
		// create menu and store the information as an object and add to an array
		// needs to have an ID assigned to it but not by the user but by food truck
		// constructor
		// from the static field and incremented as each truck is created

		for (int i = 0; i < 5; i++) {

			if (i == 0) {
				System.out.println("Please enter the name of a food truck.");
				name = sc.nextLine();
			} else {
				System.out.println("Please enter the name of another food truck or enter quit if you'd like to stop.");
				name = sc.nextLine();
				if (name.equalsIgnoreCase("quit")) {
					break;
				}
			}
			System.out.println("What would you rate them out of 5? You can use decimals if you would like.");
			int ratingNum = sc.nextInt();
			sc.nextLine();

			System.out.println("What type of food does " + name + " serve?");
			String foodType = sc.nextLine();
			// menu
			// scanner
			// what they want to do - part of menu

//If user enters quit then it needs to end immediately but program continues
			FoodTruck truck = new FoodTruck(name, ratingNum, foodType);
			FleetTrucks[i] = truck;
		}
	}

	public void MenuChoices() {
		int choice = 0;
		while (choice != 4) {
			System.out.println("What would you like to do?");
			System.out.println("1. List all existing food trucks");
			System.out.println("2. View the average rating of food trucks.");
			System.out.println("3. Display the highest-rated food truck.");
			System.out.println("4. Quit");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				for (int i = 0; i < FleetTrucks.length; i++) {
					if (FleetTrucks[i] != null) {
						System.out.println(FleetTrucks[i].toString());
						System.out.println("---------------------------------------------------------");
					}
				}
				break;
			case 2:
				double number = 0;
				double numOfTrucks = 0;
				double average = 0;
				for (int i = 0; i < FleetTrucks.length; i++) {
					if (FleetTrucks[i] != null) {
						number += (FleetTrucks[i].getRatingNum());
						numOfTrucks++;
					} 
				}
				average = number / numOfTrucks;
				System.out.println("The average rating of all the food trucks is " + average);
				System.out.println("---------------------------------------------------------");
				break;

			case 3:
				int ratings = 0;
				int numTrucks = 0;
				String nameOfHighest = null;
				int highest = 0;
	
				for (int i = 0; i < FleetTrucks.length; i++) {
					if (FleetTrucks[i] != null) {
						ratings = FleetTrucks[i].getRatingNum();
						numTrucks++;
						if (ratings > highest) {
							highest = ratings;
							nameOfHighest = FleetTrucks[i].toString();
						}
						}
				}

				System.out.println("The highest rated food truck is " + nameOfHighest);
				System.out.println("---------------------------------------------------------");
				break;

			case 4:
				System.out.println("Thanks for playing, have a great day. Program ending...");
				System.out.println("---------------------------------------------------------");
				break;

			default:
				System.out.println("You have selected an invalid option. Please try again.");
				System.out.println("---------------------------------------------------------");
				break;
			}
			if (choice == 4) {
				break;
			}
		}

	}
}
