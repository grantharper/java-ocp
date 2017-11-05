package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BasicStreamPractice {

	
	
	public static void main(String[] args) {
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
		
		System.out.println("Serial stream for each: ");
		integerList.stream().forEach(System.out::print);
		
		System.out.println("\nSerial stream for each ordered: ");
		integerList.stream().forEachOrdered(System.out::print);
		
		System.out.println("\nParallel stream for each: ");
		integerList.stream().parallel().forEach(System.out::print);
		
		System.out.println("\nParallel stream for each ordered: ");
		integerList.parallelStream().forEachOrdered(System.out::print);
		
		
		//ordered operations skip, limit, findFirst
		
		System.out.println("\nSkip, findFirst serial: ");
		Optional<Integer> x = integerList.stream().skip(2).limit(2).findFirst();
		System.out.print(x.orElse(-1));
		
		System.out.println("\nSkip, findFirst parallel still preserves order because it is using ordered operations: ");
		Optional<Integer> y = integerList.parallelStream().skip(2).findFirst();
		System.out.print(y.orElse(-1));
		
		
		
		
	}
	
}
