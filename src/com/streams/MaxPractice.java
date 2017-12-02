package com.streams;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxPractice {

	public static void main(String[] args) {
		
		OptionalInt x = IntStream.iterate(1, i -> 1).limit(3).max();
		System.out.println(x.getAsInt());
		
		Optional<Integer> y = Stream.iterate(1, i -> ++i).limit(3).max((a, b) -> a-b);
		System.out.println(y.get());
		
	}
	
}
