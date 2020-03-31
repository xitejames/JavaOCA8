package com.acme.testing;

import com.acme.domain.Good.UnitOfMeasureType;
import com.acme.domain.Order;
import com.acme.domain.Solid;
import com.acme.utils.MyDate;

public class TestOrders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyDate date1 = new MyDate(1, 20, 2008);
		Solid anvilProduct = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", anvilProduct, 10);
		MyDate date2 = new MyDate(4, 10, 2008);
		Solid baloonProduct = new Solid("Acme Balloon", 1401, 15, UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", baloonProduct, 125);

		System.out.println(anvil);
		System.out.println(balloons);

		System.out.println("The tax Rate is currently: " + Order.getTaxRate());
		Order.calculateTaxOn(3000.00);
		anvil.calculateTax();
		balloons.calculateTax();
		Order.setTaxRate(0.06);
		System.out.println("The tax Rate is currently: " + Order.getTaxRate());
		Order.calculateTaxOn(3000.00);
		anvil.calculateTax();
		balloons.calculateTax();
		// BONUS
		MyDate date3 = new MyDate(5, 20, 2008);
		Order anotherAnvil = new Order(date3, 200, "Road Runner");
		System.out.println(anotherAnvil);
		
		// Lab 5 Work
		System.out.println("The total bill for: " + anvil + " is " + anvil.computeTotal());
		System.out.println("The total bill for: " + balloons + " is " + balloons.computeTotal());
		
		// Polymorphism lab
		System.out.println("The volume of the anvil is: " + 
		anvil.getProduct().volume());
		System.out.println("The length of the anvil is: " + 
		// Object type cast to use getLength from the solid Object
		((Solid) anvil.getProduct()).getLength());


	}

}
