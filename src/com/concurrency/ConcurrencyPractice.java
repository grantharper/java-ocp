package com.concurrency;

public class ConcurrencyPractice {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> System.out.println("lambda"));
		Thread t2 = new Thread(new A());
		
		t1.start();
		t2.start();
	}
	
	
}

class A implements Runnable {

	@Override
	public void run() {
		System.out.println("class");
		
	}
	
}
