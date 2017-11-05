package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionPractice {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		Optional<Integer> resultReduction = list.stream().reduce((x, y) -> x + y);

		System.out.println("Reduction result for binary operator: " + resultReduction.orElse(-1)); // 15

		// has an identity in this signature so you don't need the optional
		Integer resultReduction2 = list.stream().reduce(2, (x, y) -> x + y);

		System.out.println("Reduction result for binary operation with identity: " + resultReduction2); // 17

		String resultReduction3 = list.stream().reduce("", (String s1, Integer x) -> s1 + x,
				(String s2, String s3) -> s2 + s3);

		System.out.println("Reduction result for accumulator and combiner: " + resultReduction3);

		
		//for parallel streams
		System.out.println("Number of processors: " + Runtime.getRuntime().availableProcessors());
		//identity combiner.apply(identity, u) must equal u
		Integer parallelReduction1 = list.parallelStream().reduce(2, (x, y) -> x + y); //not legal because it alters the result (if you have more than 5 processors, adds 10)
		System.out.println("Parallel reduction: " + parallelReduction1);
		
		Integer parallelReduction2 = list.parallelStream().reduce(0, (x, y) -> x + y);
		System.out.println("Parellel reduction: " + parallelReduction2); //will return 15 just like serial because identity is observed
		
		//accumulator must be associative (a op b) op c = a op (b op c)
		//division is not associative
		Double serialReduction3 = list.stream().reduce(2.0, (d, x) -> x / d, (d1, d2) -> d1 + d2);
		System.out.println("Serial reduction non-associative: " + serialReduction3);
		//example of breaking this rule
		Double parallelReduction3 = list.parallelStream().reduce(2.0, (d, x) -> x / d, (d1, d2) -> d1 + d2);
		System.out.println("Parallel reduction non-associative: " + parallelReduction3);
		
		//combiner must be associative and stateless and compatible with the identity
		Double serialReduction4 = list.stream().reduce(1.0, (d,  x) -> x * d, (d1, d2) -> d1 + d2);
		System.out.println("Serial reduction combiner is non-associative: " + serialReduction4);
		
		Double parallelReduction4 = list.parallelStream().reduce(1.0, (d, x) -> x * d, (d1, d2) -> d1 + d2);
		System.out.println("Parallel reduction combiner is non-associative: " + parallelReduction4);
		
		Double serialReduction5 = list.stream().reduce(1.0, (d,  x) -> x * d, (d1, d2) -> d1 * d2);
		System.out.println("Serial reduction that follows all rules to parallelize: " + serialReduction5);
		
		Double parallelReduction5 = list.parallelStream().reduce(1.0, (d, x) -> x * d, (d1, d2) -> d1 * d2);
		System.out.println("Parallel reduction should have same result: " + parallelReduction5);
		
		System.out.println(1.0 / (2.0 / 3));
		System.out.println((1.0 / 2) / 3);
	}

}
