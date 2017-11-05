package com.concurrency;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class CoffeeShop {
	
	private AtomicLong totalOrders = new AtomicLong(0);
	
	private AtomicLong totalCompletedOrders = new AtomicLong(0);

	private final ConcurrentLinkedQueue<Order> orders = new ConcurrentLinkedQueue<>();

	private final ConcurrentLinkedQueue<Coffee> onBar = new ConcurrentLinkedQueue<>();

	// maybe put a completed order Future list here to dump completed order to

	private final Runnable orderCoffee = () -> {
		orders.offer(new Order.OrderBuilder().setType("Ethiopia").build());
		totalOrders.incrementAndGet();
	};
	
	private final Runnable pickUpCoffee = () -> {
		if(onBar.peek() != null){
			onBar.poll();
			System.out.println("Wow this coffee is delicious!");
		}
	};

	private final Runnable brewCoffee = () -> {
		if (orders.peek() != null) {
			Coffee c = new Coffee.CoffeeBrewer().setType(orders.poll().getCoffeeType()).build();
			onBar.offer(c);
			totalCompletedOrders.incrementAndGet();
		} else {
			System.out.println("No orders available for barista");
		}

	};

	public static void main(String[] args) {

		CoffeeShop swings = new CoffeeShop();

		ScheduledExecutorService baristas = null;
		ScheduledExecutorService customers = null;

		try {

			baristas = Executors.newScheduledThreadPool(4);

			customers = Executors.newScheduledThreadPool(20);

			customers.scheduleAtFixedRate(swings.orderCoffee, 1, 5, TimeUnit.SECONDS);
			
			customers.scheduleAtFixedRate(swings.pickUpCoffee, 10, 5, TimeUnit.SECONDS);

			baristas.scheduleWithFixedDelay(swings.brewCoffee, 2, 10, TimeUnit.SECONDS);
			
			baristas.scheduleWithFixedDelay(swings.brewCoffee, 10, 10, TimeUnit.SECONDS);

			while (true) {
				Thread.sleep(2000);
				System.out.print("[Orders:" + swings.orders.size() + "]");

				System.out.print("[On bar:" + swings.onBar.size() + "]");
				
				System.out.print("[TotalOrders:" + swings.totalOrders.get() + "]");
				System.out.print("[TotalCompletedOrders:" + swings.totalCompletedOrders.get() + "]");
				
				System.out.println();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (baristas != null)
				baristas.shutdown();
		}

	}

}

class Order {
	private final String coffeeType;

	private Order(String coffeeType) {
		this.coffeeType = coffeeType;
	}

	public String getCoffeeType() {
		return this.coffeeType;
	}

	public static class OrderBuilder {

		private String type;

		public OrderBuilder setType(String type) {
			this.type = type;
			return this;
		}

		public Order build() {
			return new Order(this.type);
		}
	}

	public String toString() {
		return "Order up for coffee type " + this.coffeeType;
	}
}

class Coffee {
	private final String type;

	private Coffee(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static class CoffeeBrewer {

		private String type;

		public CoffeeBrewer setType(String type) {
			this.type = type;
			return this;
		}

		public Coffee build() {
			return new Coffee(this.type);
		}

	}

	public String toString() {
		return "Hot Coffee type" + this.type;
	}
}
