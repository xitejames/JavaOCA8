package com.acme.testing;

import com.acme.utils.MyDate;

public class TestMyDate {
	public static void main(String[] args) {
		MyDate date1 = new MyDate(11, 11, 1918);
		MyDate date2 = new MyDate();
		date2.setDay(11);
		date2.setMonth(11);
		date2.setYear(1918);
		MyDate date3 = new MyDate();
		date3.setDate(13, 40, -1);

		date3.setDay(4);
		date3.setMonth(21);
		date3.setYear(1968);
		String str1 = date1.toString();
		String str2 = date2.toString();
		String str3 = date3.toString();
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		//TEST INIT BLOCK -BONUS
		MyDate date4 = new MyDate();
		String str4 = date4.toString();
		System.out.println(str4);
//		// TEST LAB 5 LEAP YEARS
//		MyDate.leapYears();


	}
}