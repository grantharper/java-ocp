package com.concurrency;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;

public class ExecutorExample {
	static final int CAPACITY = 3;

	public static void main(String[] args) {

		Runnable r1 = () -> System.out.println("A");
		Runnable r2 = () -> System.out.println("B");
		Runnable r3 = () -> System.out.println("C");

		X x = new X();
		x.execute(r1);
		x.execute(r2);
		x.execute(r3);

		Y y = new Y();
		y.execute(r1);
		y.execute(r2);
		y.execute(r3);

	}
}

class X implements Executor {

	private final Queue<Runnable> tasks = new ArrayBlockingQueue<>(ExecutorExample.CAPACITY);

	@Override
	public void execute(Runnable command) {
		tasks.offer(command);

		if (tasks.size() == ExecutorExample.CAPACITY) {
			System.out.println("X implementation");
			//non-deterministic order because a new thread is started for each task 
			new Thread(tasks.poll()).start();
			new Thread(tasks.poll()).start();
			new Thread(tasks.poll()).start();
		}

	}

}

class Y implements Executor {
	private final Queue<Runnable> tasks = new ArrayBlockingQueue<>(ExecutorExample.CAPACITY);

	@Override
	public void execute(Runnable command) {
		tasks.offer(command);

		if (tasks.size() == ExecutorExample.CAPACITY) {
			System.out.println("Y implmentation");
			//print A B C because it is using the same thread (run method only)
			tasks.poll().run();
			tasks.poll().run();
			tasks.poll().run();

		}

	}

}
