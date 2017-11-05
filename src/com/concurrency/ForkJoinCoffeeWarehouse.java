package com.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class ForkJoinCoffeeWarehouse extends RecursiveAction {

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
			// perform task
			for (int i = start; i < end; i++) {
				weights[i] = (double) new Random().nextInt(100);
				System.out.println("Coffee weighed: " + i);
			}
		} else {
			// fork task
			int middle = start + (end - start) / 2;
			System.out.println("start=" + start + "middle=" + middle + "end=" + end);
			invokeAll(new ForkJoinCoffeeWarehouse(start, middle, weights),
					new ForkJoinCoffeeWarehouse(middle, end, weights));
		}

	}

	public static void main(String[] args) {
		Double[] weights = new Double[50];

		ForkJoinTask<?> task = new ForkJoinCoffeeWarehouse(0, weights.length, weights);
		ForkJoinPool pool = new ForkJoinPool();

		pool.invoke(task);

		System.out.println();
		System.out.println("Weights: ");
		Arrays.asList(weights).stream().forEach(d -> System.out.print(d.intValue() + " "));

	}

}
