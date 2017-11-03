package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class FlatMapPractice
{

  public static void main(String[] args)
  {
    List<String> coffee = Arrays.asList("gold coast", "snooze am", "ethiopia", "sumatra");
    List<String> teas = Arrays.asList("earl grey", "spiced chai", "chamomile", "sweet orange");
    
    System.out.println("Lists of drinks");
    List<List<String>> drinkLists = new ArrayList<>();
    drinkLists.add(coffee);
    drinkLists.add(teas);
    System.out.println(drinkLists);
    
    System.out.println("Drinks after flat map");
    List<String> drinks = drinkLists.stream().flatMap(a -> a.stream()).collect(Collectors.toList());
    System.out.println(drinks);
    
    System.out.println("Average string length for all drinks");
    OptionalDouble averageDrinkLength = drinkLists.stream().flatMapToInt(a -> a.stream().mapToInt(String::length)).average();
    
    averageDrinkLength.ifPresent(System.out::println);
    
    
    
    
  }
  
}
