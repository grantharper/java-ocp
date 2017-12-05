package com.assertions;

public class AssertionsAreDumb {

	//in order for this to work, the run configurations need to pass -ea as a VM argument (to enable assertions)
  //to enable assertions for a specific package: -ea:package...
  //to enable assertions for a specific class: -ea:class
  //each command modifies the one before it: -ea -da:disabledclass would enable assertions globally but disable them for a given class
  //subpackages are affected by these flags for a parent package
  
  //Assertions require changes at the API level.
  //Code written for JDK version 1.3 can be compiled by later versions by using -source flag: javac -source 1.3 classname.java
  
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
