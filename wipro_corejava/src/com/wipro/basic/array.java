package com.wipro.basic;

public class array {
	public static void main(String[] args) {
		float[] array= {1,3,5,7};
		int target = 8;
		
		for (int i=0; i<array.length; i++)
		{
			for (int j=0; j<array.length; j++)
		{
			if (array[i] + array[j]==target);
			{
			System.out.println("indices : " +i+" ,"+j+ "]");
			}
		}
		
	}
                               
	}                  

}
