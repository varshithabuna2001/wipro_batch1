package com.exception.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.exception.employee;
//import com.exception.compare_empId;
import com.exception.compare_empsalary;

public class employeetest {
	public static void main(String[] args) {
		employee emp1 = new employee("Wipro12", "Varu", 24, 145000);
        employee emp2= new employee("Wipro20", "pavithra", 23, 50000);
        employee emp3=new employee("Wipro29", "Bhaskar", 32, 90000);
        employee emp4= new employee("Wipro51", "Raghav", 29, 55000);
		 
        List<employee> employ =new ArrayList<>(); 
        
		employ.add(emp1);
        employ.add(emp2);
        employ.add(emp3);
        employ.add(emp4);

        Collections.sort(employ, new compare_empsalary());
        employ.forEach(System.out::println);

         //Collections.sort(employ, new compare_empId());
         //employ.forEach(System.out::println);

        if(employee.getEmpsalary()<80000)
        {
        	employ.remove(employ);
        }
        	}
        }
	