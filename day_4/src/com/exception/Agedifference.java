package com.exception;

import java.time.LocalDate;
import java.time.Month;

public class Agedifference {
	static int years;
	static int  months;
	static int day;

	public static void main(String[] args) {
		LocalDate dtm1 = LocalDate.of(1977, Month.APRIL, 3);
		LocalDate dtm2 = LocalDate.of(2001, Month.JUNE, 21);
  
		difference(dtm1,dtm2);
		System.out.println("Years:"+years+ ", Months:" +months+ ", Day:"+day);
	}

	private static void difference(LocalDate dtm1, LocalDate dtm2) {
		years = dtm2.getYear()- dtm1.getYear();
		months = dtm2.getMonthValue() - dtm1.getMonthValue();
		day = dtm2.getDayOfMonth()- dtm1.getDayOfMonth();
	}
	}
