package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PrimitiveStreams
{

  public static void main(String[] args)
  {
    
    IntStream numbers = IntStream.of(1,2,3,4,5,6);
    IntStream numbers2 = IntStream.rangeClosed(1, 6);
    IntStream numbers3 = IntStream.range(1, 6);
    IntStream numbers4 = IntStream.iterate(1, i -> ++i).limit(6);
    IntStream numbers5 = IntStream.generate(() -> 1).limit(6);
    IntStream numbers6 = IntStream.concat(IntStream.of(1,2,3), IntStream.iterate(4, i -> i + 1).limit(3));
    System.out.print("1 through 6: ");
    numbers.forEach(System.out::print);
    System.out.print("\nrangeClosed(1,6): ");
    numbers2.forEach(System.out::print);
    System.out.print("\nrange(1,6): ");
    numbers3.forEach(System.out::print);
    System.out.print("\niterate(1, i-> ++i).limit(6): ");
    numbers4.forEach(System.out::print);
    System.out.print("\ngenerate(()->1): ");
    numbers5.forEach(System.out::print);
    System.out.print("\nconcat(IntStream.of(1,2,3), IntStream.iterate(4, i -> i + 1).limit(3)): ");
    numbers6.forEach(System.out::print);

    List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
    System.out.print("\nUsing a toIntFunction mapToInt to make primitives out of wrapper type Integer: ");
    list1.stream().mapToInt(i -> i).forEach(System.out::print);
    
    IntStream stream = IntStream.of(1,2,3,4,5,6);
    System.out.print("\nUsing an IntFunction mapToObj to make String out of int: ");
    stream.mapToObj(i -> String.valueOf(i)).forEach(System.out::print);
  }
  
}
