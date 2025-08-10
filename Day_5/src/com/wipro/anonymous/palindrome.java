package com.wipro.anonymous;
import java.util.function.Predicate;

public class palindrome {

public static void main(String[] args) {
        
        Predicate<String> isPalindrome = str -> {
            String reversed = new StringBuilder(str).reverse().toString();
            return str.equalsIgnoreCase(reversed);
        };
        String input = "wow";
        System.out.println(isPalindrome.test(input));
        
        String input1 = "save";
        System.out.println(isPalindrome.test(input1));
    }

}
