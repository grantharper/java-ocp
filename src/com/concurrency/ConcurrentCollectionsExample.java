package com.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollectionsExample {

	static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

	static List<String> nonconcurrentList = new ArrayList<>();

	public static void main(String[] args) {

		Runnable r1 = () -> nonconcurrentList.add("1");
		Runnable r2 = () -> nonconcurrentList.add("2");
		Runnable r3 = () -> nonconcurrentList.add("3");

		Runnable r4 = () -> list.add("A");
		Runnable r5 = () -> list.add("B");
		Runnable r6 = () -> list.add("C");

		for (int i = 0; i < 10; i++) {
			new Thread(r4).start();
			new Thread(r5).start();
			new Thread(r6).start();
			System.out.println("concurrent list print");
			print(list);
		}

		
		//will throw ConcurrentModificationException
		for (int i = 0; i < 10; i++) {
			new Thread(r1).start();
			new Thread(r2).start();
			new Thread(r3).start();
			System.out.println("regular list print");
			print(nonconcurrentList);
		}
	}

	static void print(List<String> list) {
		list.forEach(System.out::println);
	}

}
