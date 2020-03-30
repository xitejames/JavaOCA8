package com.acme.utils;

public class MyDate {
	public int day;
	public int month;
	public int year;
	
	// INITIALISATION BLOCK - BONUS
	{
		this.day = 1;
		this.month = 1;
		this.year = 2000;
	}
	
	public MyDate() {};

	public MyDate(int newYear, int newMonth, int newDay){
		this.day = newDay;
		this.month = newMonth;
		this.year = newYear;
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
		//	 they increment by 4 (which makes sense as this skips all the ones that will
		//	 instantly fails aka not multiples of 4
		for (int i = 1752; i <= 2020; i = i + 4) {
			// Just then has 2 checks to make its not a multiple of 100 but is a multiple of 400
			if ((i % 100 != 0) || (i % 400 == 0))
				System.out.println("The year " + i + " is a leap year");
		}
	}
	
	public String toString() {
		return "The CurrentDate is: " + day + ":"+ month + ":"+ year ;
	}

	public int getDay() {
		return day;
	}

	public void setDay(final int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(final int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(final int month) {
		this.month = month;
	}
	
}
