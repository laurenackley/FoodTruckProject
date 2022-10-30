package com.skilldistillery.foodtruck.entities;

public class FoodTruck {
	private static int numberOfTrucks = 0; // don't pass as a ID field ONLY other static 
	private String name; 
	private double ratingNum;
	private String foodType;
	private int truckID;
	
	public FoodTruck() {
	}
	
	public FoodTruck (String name, double ratingNum, String foodType) {
		this.name = name;
		this.ratingNum = ratingNum;
		this.foodType = foodType;
		numberOfTrucks++;
		truckID = numberOfTrucks;
	}
	
	public static int getNumberOfTrucks() {
		return numberOfTrucks;
	}

	public static void setNumberOfTrucks(int numberOfTrucks) {
		FoodTruck.numberOfTrucks = numberOfTrucks;
	}

	public int getTruckID() {
		return truckID;
	}

	public void setTruckID(int truckID) {
		this.truckID = truckID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRatingNum() {
		return ratingNum;
	}

	public void setRatingNum(double ratingNum) {
		this.ratingNum = ratingNum;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	@Override
	public String toString() {
		return "FoodTruck: " + name + "\nRating: " + ratingNum + "\nFoodType:" + foodType;
	}


}
