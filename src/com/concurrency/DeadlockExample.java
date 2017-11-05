package com.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {

	public static void main(String[] args) {
		// Deadlock Example
		new Thread(() -> deadlock1()).start();
		new Thread(() -> deadlock2()).start();

		// Livelock Example
		new Thread(() -> livelock1()).start();
		new Thread(() -> livelock2()).start();

	}

	static void deadlock1() {
		ADead.getA();
		BDead.getB();
		BDead.releaseB();
		ADead.releaseA();
	}

	static void deadlock2() {
		BDead.getB();
		ADead.getA();
		ADead.releaseA();
		BDead.releaseB();
	}

	static void livelock1() {
		boolean gotboth = false;
		while (!gotboth) {
			ADead.getA();
			if (BDead.acquiredB()) {
				BDead.releaseB();
				ADead.releaseA();
				System.out.println("Releasing all");
				gotboth = true;
			} else {
				ADead.releaseA();
			}
		}
	}

	static void livelock2() {
		boolean gotboth = false;
		while (!gotboth) {
			BDead.getB();
			if (ADead.acquiredA()) {
				ADead.releaseA();
				BDead.releaseB();
				System.out.println("Releasing all");
				gotboth = true;
			} else {
				BDead.releaseB();
			}
		}
	}

}

class ADead {
	static ReentrantLock lock = new ReentrantLock();

	static void getA() {
		lock.lock();
		System.out.println("A locked");
	}

	static void releaseA() {
		lock.unlock();
		System.out.println("A unlocked");
	}

	static boolean acquiredA() {
		if (lock.isHeldByCurrentThread()) {
			return true;
		} else {
			return false;
		}
	}

}

class BDead {
	static ReentrantLock lock = new ReentrantLock();

	static void getB() {
		lock.lock();
		System.out.println("B locked");
	}

	static void releaseB() {
		lock.unlock();
		System.out.println("B unlocked");
	}

	static boolean acquiredB() {
		if (lock.isHeldByCurrentThread()) {
			return true;
		} else {
			return false;
		}
	}
}
