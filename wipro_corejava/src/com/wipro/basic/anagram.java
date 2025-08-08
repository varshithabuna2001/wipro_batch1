package com.wipro.basic;

import java.util.Arrays;

public class anagram {
   public static void main(String[] args) {
	   String str= "HEART";
	   String str1="EARTH";
	   
	   char[] arr1 = str.toCharArray();
	   char[] arr2 = str1.toCharArray();
	     
	   Arrays.sort(arr1);
	   Arrays.sort(arr2);
	    
	   if(arr1.equals(arr2))
		   System.out.println("Anagram");
	   else
		   System.out.println("not anagram");
	   
			
	   
}

}
