package com.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

	static ScheduledExecutorService ses = Executors.newScheduledThreadPool(10, (r) -> new Thread(r));
	
	public static void main(String[] args) {
		ses.schedule(() -> System.out.println("1"), 1, TimeUnit.SECONDS);
		ses.schedule(() -> System.out.println("2"), 2, TimeUnit.SECONDS);
		
		ScheduledFuture<String> future = ses.schedule(() -> "A", 3, TimeUnit.SECONDS);
		try{
			while(true){
				System.out.println(future.get());
				if(future.isDone()){
					break;
				}else{
					Thread.sleep(500);
				}
				
			}
		}catch(InterruptedException | ExecutionException e){
			e.printStackTrace();
		}finally{
			if(ses != null) ses.shutdown();
		}
		
	}
	
	
}
