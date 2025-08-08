package com.exception;

import java.util.Comparator;

public class compare_empId implements Comparator<employee>
{
	public int compare(employee emp1, employee emp2) {
	return emp1.empid.compareTo(emp2.empid);
	}
}

