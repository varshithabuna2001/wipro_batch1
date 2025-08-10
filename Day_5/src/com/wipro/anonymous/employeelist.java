package com.wipro.anonymous;

import java.util.ArrayList;
import java.util.List;

public class employeelist {
	public static void main(String[] args) {
		List <employe> employ =new ArrayList<>();

		employ.add(new employe( "Varu", 24, 145000));
        employ.add(new employe ("pavithra", 23, 50000));
        employ.add(new employe("Bhaskar", 32, 90000));
        employ.add(new employe("Raghav", 29, 55000)); 
         
        employ.sort((e1,e2) ->Double.compare(e1.empsalary, e2.empsalary));
        for (employe e :employ)
        {
        	System.out.println(e);
        }
        
	}
}
