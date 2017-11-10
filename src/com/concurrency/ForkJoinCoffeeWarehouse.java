package com.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinCoffeeWarehouse extends RecursiveAction {

  private static final long serialVersionUID = 3893370181018250694L;
  private int start;
	private int end;
	private Double[] weights;

	public ForkJoinCoffeeWarehouse(int start, int end, Double[] weights) {
		this.start = start;
		this.end = end;
		this.weights = weights;
	}

	@Override
	protected void compute() {
		if (end - start <= 3) {
		  System.out.println("Small enough task: start=" + start + " end=" + end);
			// perform task
			for (int i = start; i < end; i++) {
				weights[i] = (double) new Random().nextInt(100);
				System.out.println("Coffee weighed: " + i);
			}
		} else {
			// fork task
			int middle = start + (end - start) / 2;
			System.out.println("Large task to split: start=" + start + " middle=" + middle + " end=" + end);
			invokeAll(new ForkJoinCoffeeWarehouse(start, middle, weights),
					new ForkJoinCoffeeWarehouse(middle, end, weights));
		}

	}

	public static void main(String[] args) {
		Double[] weights = importCoffee();

		ForkJoinTask<?> task = new ForkJoinCoffeeWarehouse(0, weights.length, weights);
		ForkJoinPool pool = new ForkJoinPool(1);

		pool.invoke(task);

		System.out.println();
		System.out.println("Weights: ");
		Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue() + " "));

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
