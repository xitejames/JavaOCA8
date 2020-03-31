package com.acme.testing;

import com.acme.domain.Good.UnitOfMeasureType;

import java.time.LocalDate;
import java.time.Period;

import com.acme.domain.Order;
import com.acme.domain.Service;
import com.acme.domain.Solid;
import com.acme.utils.MyDate;

public class TestOrders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyDate date1 = new MyDate(20, 1, 2008);
		Solid s1 = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", s1, 10);
		MyDate date2 = new MyDate(10, 4, 2008);
		Solid s2 = new Solid("Acme Balloon", 1401, 15, UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", s2, 125);
		balloons.setQuantity(-200);
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
		System.out.println("The total bill for: " + anvil + " is " + anvil.computeTotal());
		System.out.println("The total bill for: " + balloons + " is" + balloons.computeTotal());

		// BONUS
		MyDate date3 = new MyDate(1, 1, 2020);
		Order anotherAnvil = new Order(date3, 200, "Road Runner");
		System.out.println(anotherAnvil);

		// Lab 5 Work Bonus
		System.out.println("The total bill for: " + anvil + " is " + anvil.computeTotal());
		System.out.println("The total bill for: " + balloons + " is " + balloons.computeTotal());
		
		
		// Check to see lamdba expression works with date
		MyDate hammerDate = new MyDate(26, 03, 2020);
		Solid hammerType = new Solid("Acme Hammer", 281, 0.3, UnitOfMeasureType.CUBIC_METER, false, 100, 0.25, 0.3);
		Order hammer = new Order(hammerDate, 10.00, "Wile E Coyote", hammerType, 10);


		// Polymorphism lab Bonus
		System.out.println("The volume of the anvil is: " + ((Solid) anvil.getProduct()).volume());
		System.out.println("The length of the anvil is: " +
		// Object type cast to use getLength from the solid Object
				((Solid) anvil.getProduct()).getLength());

		Service s3 = new Service("Road Runner Eradication", 14, false);
		Order birdEradication = new Order(date3, 20000, "Daffy Duck", s3, 1);
		System.out.println("The total bill for: " + birdEradication + " is " + birdEradication.computeTotal());

		// Lambda expression interface Lab
		// it is Order becuase the function is static
		// and the orderDate and orderAmount is the variables straight from the class
		Order.setRushable((orderDate, orderAmount) -> {
			// To check time I used the Period to get the time difference and then checked in the months between the two where greater than 1
			Period timeDifference = Period.between(LocalDate.of(orderDate.getYear(), orderDate.getMonth(), orderDate.getDay()), LocalDate.now());
			return orderAmount > 1500 || timeDifference.getMonths() >= 1;
		});
		
		System.out.println("Anvil isPriorityOrder: " + anvil.isPriorityOrder()); // true
		System.out.println("Balloons isPriorityOrder: " + balloons.isPriorityOrder()); // false
		System.out.println("Hammer isPriorityOrder: " + hammer.isPriorityOrder()); //false
	}

}
