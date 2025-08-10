package com.wipro.anonymous;
import java.util.Optional;


public class optexample {

		    public static void main(String[] args) {
		        Optional<Integer> number = Optional.of(42);
		        number.ifPresent(value -> System.out.println("Value present: " + value));

		        Optional<String> emptyString = Optional.empty();
		        
		        String result = emptyString.orElse("Default Value");
		        System.out.println("String value: " + result);
		    }
		}


