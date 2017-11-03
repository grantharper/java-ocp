package com.functional;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class PrimitiveFunctional
{

  public static void main(String[] args)
  {

    List<String> drinks = Arrays.asList("coffee", "tea", "water");

    drinks.stream()
          .mapToInt(String::length)
          .forEach(System.out::println);

    drinks.stream()
          .flatMapToInt(x ->
          {
            return Arrays.asList(x.length(), x.indexOf("e"))
                         .stream()
                         .mapToInt(b -> b);
          })
          .forEach(System.out::println);

    IntStream range = IntStream.range(1, 6);
    range.forEach(a -> System.out.print(a + ", "));
    
    System.out.println("Average of numbers 1 through 20: ");
    IntStream oneThroughTwenty = IntStream.rangeClosed(1, 20);
    OptionalDouble average = oneThroughTwenty.average();
    
    average.ifPresent(System.out::print);
    
    average.orElse(Double.NaN);
    
    average.orElseGet(() -> 10.0);
    
    
  }

}
