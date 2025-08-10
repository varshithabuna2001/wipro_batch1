package com.wipro.anonymous;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class api_names {

	public static void main(String[] args) {
		List<String> Name= Arrays.asList("Anjali","Ajay","Arav","Jay","Janaki","Jivesh");
		        List<String> names = Name.stream()
		        		                  .filter(name -> name.toLowerCase().contains("ja")||name.toLowerCase().contains("aj"))
		        		                  .collect(Collectors.toList());
		        
		System.out.println("Names:" +names);
				}
}
