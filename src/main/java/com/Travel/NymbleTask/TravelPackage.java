package com.Travel.NymbleTask;

import java.util.*;

public class TravelPackage {
	private String name;
	private int passengerCapacity;
	private List<Destination> itinerary;
	private List<Passenger> passengers;

	public TravelPackage(String name, int passengerCapacity) {
		this.name = name;
		this.passengerCapacity = passengerCapacity;
		this.itinerary = new ArrayList<>();
		this.passengers = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public List<Destination> getItinerary() {
		return itinerary;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void addDestination(Destination destination) {
		itinerary.add(destination);
	}

	public void addPassenger(Passenger passenger) {
		passengers.add(passenger);
	}

	public void printItinerary() {
		System.out.println("Travel Package: " + name);
		for (Destination destination : itinerary) {
			System.out.println("Destination: " + destination.getName());
			for (Activity activity : destination.getActivities()) {
				System.out.println("Activity: " + activity.getName());
				System.out.println("Description: " + activity.getDescription());
				System.out.println("Cost: " + activity.getCost());
				System.out.println("Capacity: " + activity.getCapacity());
			}
		}
	}

	public void printPassengerList() {
		System.out.println("Passenger List for Travel Package: " + name);
		System.out.println("Passenger Capacity: " + passengerCapacity);
		System.out.println("Number of Passengers Enrolled: " + passengers.size());
		for (Passenger passenger : passengers) {
			System.out.println(
					"Passenger Name: " + passenger.getName() + ", Passenger Number: " + passenger.getPassengerNumber());
		}
	}

	public void printPassengerDetails(Passenger passenger) {
		System.out.println("Passenger Details:");
		System.out.println("Name: " + passenger.getName());
		System.out.println("Passenger Number: " + passenger.getPassengerNumber());
		if (passenger instanceof StandardPassenger || passenger instanceof GoldPassenger) {
			System.out.println("Balance: " + passenger.getBalance());
		}
		System.out.println("Activities Enrolled:");
		for (Destination destination : itinerary) {
			for (Activity activity : destination.getActivities()) {
				if (activity.getBooked() > 0) {
					System.out.println("Destination: " + destination.getName());
					System.out.println("Activity: " + activity.getName());
					double pricePaid = activity.getCost();
					if (passenger instanceof GoldPassenger) {
						pricePaid *= 0.9; // 10% discount for gold passenger
					}
					System.out.println("Price Paid: " + pricePaid);
				}
			}
		}
	}

	public void printAvailableActivities() {
		System.out.println("Available Activities:");
		for (Destination destination : itinerary) {
			for (Activity activity : destination.getActivities()) {
				if (activity.hasSpace()) {
					System.out.println("Destination: " + destination.getName());
					System.out.println("Activity: " + activity.getName());
					System.out.println("Spaces Available: " + (activity.getCapacity() - activity.getBooked()));
				}
			}
		}
	}
}

class StandardPassenger extends Passenger {
	public StandardPassenger(String name, int passengerNumber, double balance) {
		super(name, passengerNumber, balance);
	}
}

class GoldPassenger extends Passenger {
	public GoldPassenger(String name, int passengerNumber, double balance) {
		super(name, passengerNumber, balance);
	}
}

class PremiumPassenger extends Passenger {
	public PremiumPassenger(String name, int passengerNumber) {
		super(name, passengerNumber, 0); // Premium passengers have no balance
	}

}
