package com.Travel.NymbleTask;

public class Activity {
	private String name;
	private String description;
	private double cost;
	private int capacity;
	private int booked;

	public Activity(String name, String description, double cost, int capacity) {
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.capacity = capacity;
		this.booked = 0;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getCost() {
		return cost;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getBooked() {
		return booked;
	}

	public void book() {
		booked++;
	}

	public boolean hasSpace() {
		return booked < capacity;
	}

	public static void main(String[] args) {

		Activity activity1 = new Activity("Sightseeing Tour", "Guided tour of the city landmarks", 50.0, 20);
		Activity activity2 = new Activity("Snorkeling", "Explore underwater life", 80.0, 15);
		Activity activity3 = new Activity("Hiking", "Trekking through scenic trails", 40.0, 25);

		
		Destination destination1 = new Destination("City A");
		destination1.addActivity(activity1);
		destination1.addActivity(activity2);

		Destination destination2 = new Destination("Island B");
		destination2.addActivity(activity2);
		destination2.addActivity(activity3);

		
		StandardPassenger standardPassenger = new StandardPassenger("John", 1001, 200.0);
		GoldPassenger goldPassenger = new GoldPassenger("Alice", 1002, 500.0);
		PremiumPassenger premiumPassenger = new PremiumPassenger("Bob", 1003);

		TravelPackage travelPackage = new TravelPackage("Adventure Package", 30);
		travelPackage.addDestination(destination1);
		travelPackage.addDestination(destination2);

		travelPackage.addPassenger(standardPassenger);
		travelPackage.addPassenger(goldPassenger);
		travelPackage.addPassenger(premiumPassenger);

		activity1.book();
		activity2.book();

	}
}
