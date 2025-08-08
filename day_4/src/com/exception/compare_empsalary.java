package com.exception;

import java.util.Comparator;

public class compare_empsalary implements Comparator<employee>
	{
		public int compare(employee emp1, employee emp2) {
		return Double.compare(emp1.empsalary, emp2.empsalary);
		}
	
}
