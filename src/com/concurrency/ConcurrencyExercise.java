package com.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyExercise {

	private ReentrantLock lock = new ReentrantLock();

	ExecutorService service = Executors.newFixedThreadPool(10);

	private volatile int a = 0;
	private int b = 0;

	private AtomicInteger atomic = new AtomicInteger(0);

	Runnable rNotSync = () -> {
		incrementNotSynchronized("rNotSync");
	};
	Runnable rLock = () -> {
		incrementWithLock("rLock");
	};
	Runnable rSync = () -> {
		incrementSynchronized("rSync");
	};
	Runnable rAtomic = () -> {
		incrementAtomic("rAtomic");
	};

	public void notSynchronized() {

		for (int i = 0; i < 5; i++) {
			service.execute(rNotSync);
		}
		printB();

	}

	public void synchronizedExample() {
		for (int i = 0; i < 5; i++) {
			service.execute(rSync);
		}
	}

	public void lockExample() {
		for (int i = 0; i < 5; i++) {
			service.execute(rLock);
		}
	}

	public void atomicExample() {
		for (int i = 0; i < 5; i++) {
			service.execute(rAtomic);
		}
	}

	public static void main(String[] args) {
		ConcurrencyExercise ce = new ConcurrencyExercise();
		System.out.println("1 - Not Sync, 2 - Sync, 3 - Locked, 4 - Atomic");
		String option = "1";
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter which option you would like to simulate\n");
			option = br.readLine();
			
			if (option.equals("1")) {
				System.out.println("Not synchronized");
				ce.notSynchronized();
			}

			if (option.equals("2")) {
				System.out.println("Synchronized");
				ce.synchronizedExample();
			}

			if (option.equals("3")) {
				System.out.println("Locked");
				ce.lockExample();
			}

			if (option.equals("4")) {
				System.out.println("Atomic");
				ce.atomicExample();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			System.exit(0);
		}

		
		//System.exit(0);
	}

	public void incrementNotSynchronized(String id) {
		// System.out.println(id);
		b++;
		// printB();
	}

	public synchronized void incrementSynchronized(String id) {
		System.out.println(id);
		a++;
		printA();
	}

	public void incrementWithLock(String id) {
		System.out.println(id);
		try {
			if (lock.tryLock(100000, TimeUnit.NANOSECONDS)) { // if you change the
															// time, it will
															// change how many
															// threads can
															// access
				a++;
				printA();

			} else {
				System.out.println(id + ": object locked, can't increment");
			}
		} catch (InterruptedException e) {
			System.out.println(id + ": Interrupted Exception");
		} finally {
			lock.unlock();
		}

	}

	private void incrementAtomic(String string) {

		System.out.println("atomic=" + atomic.incrementAndGet());
	}

	public void printA() {
		System.out.println("a=" + this.a);
	}

	public void printB() {
		System.out.println("b=" + this.b);
	}

}
