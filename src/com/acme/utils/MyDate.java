package com.acme.utils;

public class MyDate {
	private byte day;
	private byte month;
	private int year;

	// INITIALISATION BLOCK - BONUS
	{
		this.day = 1;
		this.month = 1;
		this.year = 2000;
	}

	 // The default constructor
	 public MyDate() {
	 this(1,1,1900);
	 }


	public MyDate(int newYear, int newMonth, int newDay) {
		this.day = (byte) newDay;
		this.month = (byte) newMonth;
		this.year = (byte) newYear;
	}

//	// How I started to do it
//	public static void leapYears() {
//		for (int startYear = 1752; startYear <= 2020; startYear++) {
//			boolean isItALeapYear = false;
//			if (startYear % 4 == 0) {
//				isItALeapYear = true;
//				if (startYear % 100 == 0 ) {
//					isItALeapYear = false;
//				}
//				if (startYear % 400 == 0) {
//					isItALeapYear = true;
//				}
//			}
//			if (isItALeapYear) {
//				System.out.println("The Year " + startYear + " is a leap year");
//			}
//		}
//	}

	// 4 lines for loop instead of my huge loop of 15
	public static void leapYears() {
		// they increment by 4 (which makes sense as this skips all the ones that will
		// instantly fails aka not multiples of 4
		for (int i = 1752; i <= 2020; i = i + 4) {
			// Just then has 2 checks to make its not a multiple of 100 but is a multiple of
			// 400
			if ((i % 100 != 0) || (i % 400 == 0))
				System.out.println("The year " + i + " is a leap year");
		}
	}

	private boolean valid(int day, int month, int year) {
		if (day > 31 || day < 1 || month > 12 || month < 1) {
			System.out.println("Attempting to create a non-valid date " + month + "/" + day + "/" + year);
			return false;
		}
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			return (day <= 30);
		case 2:
			return day <= 28 || (day == 29 && year % 4 == 0);
		}
		return true;
	}

	public String toString() {
		return "The CurrentDate is: " + day + ":" + month + ":" + year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(final int day) {
		if (valid(day, this.month, this.year)) {
			this.day = (byte) day;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(final int year) {
		if (valid(this.day, this.month, year)) {
			this.year = year;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(final int month) {
		if (valid(this.day, month, this.year)) {
			this.month = (byte) month;
		}
	}

	public void setDate(int day, int month, int year) {
		if (valid(day, month, year)) {
			this.day = (byte) day;
			this.month = (byte) month;
			this.year = year;
		}
	}

}
