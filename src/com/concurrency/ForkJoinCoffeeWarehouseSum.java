package com.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinCoffeeWarehouseSum extends RecursiveTask<Double> {

  private static final long serialVersionUID = 3893370181018250694L;
  private int start;
	private int end;
	private Double[] weights;

	public ForkJoinCoffeeWarehouseSum(int start, int end, Double[] weights) {
		this.start = start;
		this.end = end;
		this.weights = weights;
	}

	@Override
	protected Double compute() {
		if (end - start <= 3) {
		  double sum = 0;
		  System.out.println("Small enough task: start=" + start + " end=" + end);
			// perform task
			for (int i = start; i < end; i++) {
				weights[i] = (double) new Random().nextInt(100);
				//System.out.println("Coffee weighed: " + i);
				sum+=weights[i];
			}
			return sum;
		} else {
			// fork task
			int middle = start + (end - start) / 2;
			System.out.println("Large task to split: start=" + start + " middle=" + middle + " end=" + end);
//			invokeAll(new ForkJoinCoffeeWarehouseSum(start, middle, weights),
//					new ForkJoinCoffeeWarehouseSum(middle, end, weights));
			RecursiveTask<Double> otherTask = new ForkJoinCoffeeWarehouseSum(start, middle, weights);
			otherTask.fork();
			return new ForkJoinCoffeeWarehouseSum(middle, end, weights).compute() + otherTask.join();
			
		}

	}

	public static void main(String[] args) {
		Double[] weights = importCoffee();

		ForkJoinTask<Double> task = new ForkJoinCoffeeWarehouseSum(0, weights.length, weights);
		ForkJoinPool pool = new ForkJoinPool();

		Double sum = pool.invoke(task);

		System.out.println();
		System.out.println("Sum of all imports: " + sum);
		System.out.println("Weights: ");
		Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue() + " "));
		
		//check work
		System.out.println();
		System.out.println("check work: " + Arrays.asList(weights).stream().mapToDouble(d -> d.doubleValue()).sum());

	}
	
	private static final int COFFEE_IMPORT_SIZE = 10;
	
	public static Double[] importCoffee(){
	  Double[] weights = new Double[COFFEE_IMPORT_SIZE];
	  for (int i = 0; i < COFFEE_IMPORT_SIZE; i++) {
      weights[i] = (double) new Random().nextInt(100);
    }
	  return weights;
	}

}
