package com.wipro.anonymous;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.function.Supplier;


public class tommorow {
	public static void main(String[] args) {
         Supplier <String> tom = () -> {DayOfWeek day = LocalDate.now().plusDays(1).getDayOfWeek();
         return day.toString();
        		 };
         System.out.println("Tommorow date:"+tom.get());
        }

}
