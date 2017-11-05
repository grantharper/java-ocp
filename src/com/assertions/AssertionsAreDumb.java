package com.assertions;

public class AssertionsAreDumb {

	//in order for this to work, the run configurations need to pass -ea as a VM argument (to enable assertions)
	public static void main(String[] args) {
		
		Square s1 = new Square(1, 2);
		
		assert s1.verify();
		
		Square s2 = new Square(-1, 3);
		//fails the assertion
		assert s2.verify();
	}
	
	
}

class Square{
	
	private int length;
	private int width;
	
	public Square(int length, int width){
		this.length = length;
		this.width = width;
	}
	
	public boolean verify(){
		System.out.println("Verifying square: " + this.toString());
		if(length > 0 && width > 0) return true;
		return false;
	}
	
	public String toString(){
		return "[length=" + this.length + "][width=" + this.width + "]";
	}
}
