package com.optional;

import java.util.Optional;

public class OptionalPractice
{

  public static void main(String[] args)
  {

    System.out.println("Empty Optional");
    Optional<String> opt = Optional.empty();
    evaluate(opt);

    System.out.println("\nOptional with a value");
    opt = Optional.of("Present!");
    evaluate(opt);

    System.out.println("\nInstantiation nuances");
    try
    {
      opt = Optional.of(null); // throws NullPointer
    } catch (NullPointerException e)
    {
      System.out.println("Null pointer caught");
    }

    opt = Optional.ofNullable(null); // this is fine
    System.out.println(opt);

  }

  private static Optional<Integer> lengthCalculator(String s)
  {
    return Optional.ofNullable(s.length());
  }

  private static void evaluate(Optional<String> opt)
  {
    System.out.println(opt.orElse("Not Present"));

    System.out.println(opt.orElseGet(() -> "Not" + "Present so Supplier"));

    try
    {
      System.out.println(opt.orElseThrow(() -> new Exception("Not present exception")));
    } catch (Exception e)
    {
      System.out.println(e.getMessage());
    }

    System.out.println("length map: " + opt.map(String::length)
                                           .orElse(0));

    System.out.println(opt.flatMap(s -> Optional.of(s))
                          .orElse("flat map optional was empty"));

    // results in Optional<Optional<Integer>> because it wraps it in Optional
    opt.map(OptionalPractice::lengthCalculator);

    System.out.println("Using flat map to allow for an optional return value from helper method: "
        + opt.flatMap(OptionalPractice::lengthCalculator)
             .orElse(0));

  }

}
