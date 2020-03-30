package com.acme.domain;

import com.acme.utils.MyDate;

public class Order {
	MyDate orderDate;
	double orderAmount = 0.00;
	String customer;
	String product;
	char jobClassification;
	int quantity;
	public static double taxRate;
	
	// BONUS
	static {
		taxRate = 0.05;
	}
	
	public Order(MyDate date, double orderAmount, String customer, String product, int quantity){
		this.orderDate=date;
		this.orderAmount=orderAmount;
		this.customer=customer;
		this.product=product;
		this.quantity=quantity;
	}
		
	// BONUS
	public Order(MyDate date, double orderAmount, String customer){
		this.orderDate=date;
		this.orderAmount=orderAmount;
		this.customer=customer;
		this.product="Anvil";
		this.quantity=1;
	}
	
	
	public String toString(){
		return quantity + " ea. " + product + " for " + customer; 
	}
	
	public static void setTaxRate(double newTaxRate) {
		taxRate = newTaxRate;
	}
	
	public static void calculateTaxOn(double amountToTax) {
		final double taxedAmount = amountToTax * taxRate;
		System.out.println("The overall tax for the order is: " + taxedAmount);
	}
	
	public double calculateTax() {
		final double taxedAmount = this.orderAmount * taxRate;
		System.out.println("The overall tax for the order is: " + taxedAmount);
		return taxedAmount;
	}
	
	public char jobSize() {
		char newClassification = 0;

		if (this.quantity <= 25) {
			newClassification = 'S';
		} else if (this.quantity >= 26 && this.quantity <= 75) {
			newClassification = 'M';
		} else if (this.quantity >= 76 && this.quantity <= 150) {
			newClassification = 'L';
		} else if (this.quantity > 150) {
			newClassification = 'X';
		}			
		return newClassification;
	}

	public double computeTotal() {
		// Create a new varible for the total cost
		double finalAmount = this.orderAmount;

		// Check order size
		// Create a new variable to act as a safe jobClassification
		char safeguardJC = Character.toUpperCase(jobSize());
		switch (safeguardJC) {
		case 'M':
			finalAmount = (finalAmount * 0.99);
			break;
		case 'L':
			finalAmount = (finalAmount * 0.98);
			break;
		case 'X':
			finalAmount = (finalAmount * 0.97);
			break;
		}
		if (this.orderAmount <= 1500.0) {
			finalAmount = finalAmount + calculateTax();
		}
		

		return finalAmount;
	}	
}
