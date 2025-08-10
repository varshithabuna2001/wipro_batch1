package com.wipro.anonymous;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;

public class FoodFilter {
    public static void main(String[] args) {
        List<FoodItem> menu = Arrays.asList(
                new FoodItem("Manchurian", "Veg", "Chinese", 150),
                new FoodItem("Chicken Fried Rice", "Non Veg", "Chinese", 900),
                new FoodItem("Pad Thai", "Non Veg", "Thai", 250),
                new FoodItem("Spring Rolls", "Veg", "Chinese", 300),
                new FoodItem("White sauce Pasta", "Veg", "Continental", 800),
                new FoodItem("Hakka Noodles", "Veg", "Chinese", 120)
        );

 
        Optional<FoodItem> chineseFoods = menu.stream()
                .filter(item -> item.getCuisine().equalsIgnoreCase("Chinese"))
                .max(Comparator.comparingDouble(FoodItem::getPrice));
                //.collect(Collectors.toList());

        System.out.println("High Price:"+chineseFoods);
        //chineseFoods.forEach(System.out::println);
    }
}