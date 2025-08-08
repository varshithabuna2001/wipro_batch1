package com.exception;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Datetime {
    public static void main(String[] args) {
        LocalDate dtm1 = LocalDate.of(2025, Month.NOVEMBER, 1);
        DateTimeFormatter dtm2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(dtm1.format(dtm2));	
	}
}