package com.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

	// shouldn't start cleaning the machine until 4 drinks have been made
	private void steamMilk() {
		System.out.println("Steaming milk");
	}

	private void pullShot() {
		System.out.println("Pulling espresso shot");
	}

	private void cleanMachine() {
		System.out.println("Cleaning espresso machine");
	}

	public void runCafe(CyclicBarrier c1, CyclicBarrier c2) throws InterruptedException, BrokenBarrierException {
		pullShot();
		//c1.await();
		steamMilk();
		c2.await();
		cleanMachine();
	}

	public static void main(String[] args) {

		CyclicBarrierExample cafeExample = new CyclicBarrierExample();

		ExecutorService service = null;
		try{
		service = Executors.newFixedThreadPool(4);

		CyclicBarrier c1 = new CyclicBarrier(1);
		CyclicBarrier c2 = new CyclicBarrier(4, () -> {
			System.out.println("Machine needs to be cleaned!!!");
		});

		for (int i = 0; i < 4; i++) {
			service.submit(() -> {
				try {
					cafeExample.runCafe(c1, c2);
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			});
		}
		}finally{
			if(service != null) service.shutdown();
		}
	}
}
