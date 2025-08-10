package com.wipro.anonymous;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Average {
	public static void main(String[] args) {
		List<Integer> lists = Arrays.asList(10,30,50,70,90,100);
		Double avg = lists.stream()
				                 .map(A->A)
				                 .collect(Collectors.averagingInt(A -> A));
				   System.out.println("Average of the list : "+avg);              
		}
}
