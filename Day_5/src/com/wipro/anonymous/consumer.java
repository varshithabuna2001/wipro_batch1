package com.wipro.anonymous;

import java.util.function.Consumer;

public class consumer {
	public static void  main(String[] args) {
	
		Consumer <Integer> even = num -> {int Nextnum = (num%2 == 0) ? num+2 : num+1;
		System.out.println("Nextnum:" +Nextnum );
	};
	even.accept(100);
	even.accept(103);
	even.accept(0);
}
}
