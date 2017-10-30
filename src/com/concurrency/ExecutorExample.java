package com.concurrency;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ExecutorExample {
	static final int CAPACITY = 3;
}

class X{
	
	private final Queue<Runnable> tasks = new ArrayBlockingQueue<>(ExecutorExample.CAPACITY);
	
	
}

class Y{
	private final Queue<Runnable> tasks = new ArrayBlockingQueue<>(ExecutorExample.CAPACITY);
	
	
}
