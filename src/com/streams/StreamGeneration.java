package com.streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamGeneration {

	public static void main(String[] args) {
		
		System.out.println("Pre-increment: ");
		IntStream.iterate(1, i -> ++i).limit(10).forEach(i -> {System.out.print(i + ",");});
		System.out.println("\nPost-increment: ");
		IntStream.iterate(1, i -> i++).limit(10).forEach(i -> {System.out.print(i + ",");});
		System.out.println("\nDouble stream multiplier");
		DoubleStream.iterate(1.0, f -> f * 2).limit(10).forEach(d -> {System.out.print(d + ",");});
	}
	
	
}
