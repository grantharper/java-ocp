package com.optional;

import java.util.OptionalDouble;

public class OptionalPrimitivePractice
{

  public static void main(String[] args)
  {
    OptionalDouble optDouble = OptionalDouble.empty();

    System.out.println("double is present: " + optDouble.isPresent());

    try
    {
      // throws exception because no value is present
      System.out.println(optDouble.getAsDouble());
    } catch (Exception e)
    {
      System.out.println(e.getMessage());
    }

    //does not throw an exception, defers to the orElse value
    System.out.println("optional is empty, so it will return the else value: " + optDouble.orElse(2.0));
    
    System.out.println("optional is empty, so it will return the else supplier: " + optDouble.orElseGet(() -> 1.0 + 1.5));
    try{
      optDouble.orElseThrow(() -> new NullPointerException("OptionalDouble is null"));
    }catch(Exception e){
      System.out.println("optional is empty, so it threw a NullPointer: " + e.getMessage());
    }
    

    optDouble = OptionalDouble.of(5.0);
    optDouble.orElse(2.0);
    System.out.print("optional contains a value, so it will print that value, not the else value: ");
    optDouble.ifPresent(System.out::println);
    
    

  }

}
