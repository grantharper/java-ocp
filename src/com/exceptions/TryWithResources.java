package com.exceptions;

public class TryWithResources {

	
	
	public static void main(String[] args) {
		try(CoffeeShop cs = new CoffeeShop("Bethanie")){
			cs.makeCoffee();
			throw new OutOfCoffeeException();
		}catch(OutOfCoffeeException e){
			e.printStackTrace();
		}finally{
			System.out.println("Go somewhere else now that Swing's is closed");
		}
		
	}
}

class OutOfCoffeeException extends RuntimeException{
	
}

class CoffeeShop implements AutoCloseable{
	
	private String baristaName;
	
	public void close(){
		System.out.println("Swing's is closed");
		throw new RuntimeException("no more sticky buns");
	}
	
	public CoffeeShop(String baristaName){
		this.baristaName = baristaName;
		
	}
	
	public void makeCoffee(){
		System.out.println("here's your extra hot mocha");
	}
	
	
}
