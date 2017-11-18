package com.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class ForkJoinAddingMachine extends RecursiveTask<Double>{


	private static final long serialVersionUID = 2311032602918441103L;
	private List<Double> numbers;
	
	public ForkJoinAddingMachine(List<Double> numbers){
		this.numbers = numbers;
	}
	
	@Override
	protected Double compute() {
		
		if(numbers.size() < 3){
			//calculate
			return numbers.stream().reduce(0.0, (x, y) -> x + y);
		}else{
			//split
			int halfway = numbers.size() / 2;
			List<Double> bottomHalf = new ArrayList<>(numbers.stream().limit(halfway).collect(Collectors.toList()));
			List<Double> topHalf = new ArrayList<>(numbers.stream().skip(halfway).collect(Collectors.toList()));
			RecursiveTask<Double> otherTask = new ForkJoinAddingMachine(bottomHalf);
			otherTask.fork();
			return new ForkJoinAddingMachine(topHalf).compute() + otherTask.join();
		}
		
	}
	
	public static void main(String[] args) {
		ForkJoinPool fjp = new ForkJoinPool();
		List<Double> numsToSum = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 23.0);
		Double simpleSum = numsToSum.stream().reduce(0.0, (x,y) -> x + y);
		Double fjpsum = fjp.invoke(new ForkJoinAddingMachine(numsToSum));
		System.out.println("SimpleSum=" + simpleSum);
		System.out.println("ForkJoinResult=" + fjpsum);
	}

	
	
	
}
