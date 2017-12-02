package com.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierForever {

	public static void await(CyclicBarrier cb){
		try{
			cb.await();
		}catch(BrokenBarrierException | InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		CyclicBarrier cb = new CyclicBarrier(3, () -> System.out.println("Barrier limit reached"));
		
		ExecutorService es = Executors.newScheduledThreadPool(2);
		for(int i = 0; i < 10; i++){
			es.submit(()-> await(cb));
		}
		
		es.shutdown(); //will only shutdown if there are no tasks waiting to complete
		//es.shutdownNow(); //will shutdown no matter what
	}
	
	
}
