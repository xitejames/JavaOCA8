package com.acme.domain;

import com.acme.domain.Good.UnitOfMeasureType;
import com.acme.utils.MyDate;

public class Order {
	private MyDate orderDate;
	private double orderAmount = 0.00;
	private String customer;
	private Product product;
	private char jobClassification;
	private int quantity;
	private static double taxRate;
	private static Rushable rushable;

	// BONUS
	static {
		taxRate = 0.05;
	}

	public Order(MyDate date, double orderAmount, String customer, Product product, int quantity) {
		setOrderDate(date);
		this.orderAmount = orderAmount;
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
	}

	// BONUS
	public Order(MyDate date, double orderAmount, String customer) {
		setOrderDate(date);
		this.orderAmount = orderAmount;
		this.customer = customer;
		// create new solid anvil product
		Solid anvilProduct = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		this.product = anvilProduct;
		this.quantity = 1;
	}

	public String toString() {
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

	// --- BOOL CHECKS --- //
	private boolean isHoliday(MyDate proposedDate) {
		boolean result = false;
		for (MyDate holiday : MyDate.getHolidays()) {
			if (holiday.equals(proposedDate)) {
				result = true;
			}
		}
		return result;
	}

	private boolean isPosotiveValue(int valueToCheck) {
		boolean isValid = false;

		if (valueToCheck >= 0) {
			isValid = true;
		} else {
			System.out.println("The value is negative failed needs to be positive.");
		}

		return isValid;
	}

	// Rushable functional interface
	public static Rushable getRushable() {
		return rushable;
	}

	public static void setRushable(Rushable rushable) {
		Order.rushable = rushable;
	}

	public boolean isPriorityOrder() {
		boolean priorityOrder = false;
		if (rushable != null) {
			priorityOrder = rushable.isRushable(orderDate, orderAmount);
		}
		return priorityOrder;
	}

	// --- GETTERS AND SETTERS --- //

	public MyDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(MyDate orderDate) {
		if (isHoliday(orderDate)) {
			System.out.println("Order date, " + orderDate + ", cannot be set to a holiday!");
		} else {
			this.orderDate = orderDate;
		}
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(final double orderAmount) {
		if (isPosotiveValue((int) orderAmount)) {
			this.orderAmount = orderAmount;
		}
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(final String customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(final Product product) {
		this.product = product;
	}

	public char getJobClassification() {
		return jobClassification;
	}

	public void setJobClassification(final char jobClassification) {
		this.jobClassification = jobClassification;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(final int quantity) {
		if (isPosotiveValue(quantity)) {
			this.quantity = quantity;
		}
	}

	public static double getTaxRate() {
		return taxRate;
	}

}
