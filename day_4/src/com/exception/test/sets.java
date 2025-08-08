package com.exception.test;

import java.util.HashSet;
import java.util.Set;

public class sets
{
	public static void main(String[] args) {
		Set<Integer> set1 = new HashSet<>();
		set1.add(6);
		set1.add(16);
		set1.add(25);
		set1.add(31);
	
	Set<Integer> set2 = new HashSet<>();
	set2.add(6);
	set2.add(16);
	set2.add(15);
	set2.add(3);
	
    System.out.println("set 1 :" + set1);
    System.out.println("set 2 :" + set2);
    
set1.removeAll(set2);

   System.out.println("Difference"+ set1);
}
}