package com.example;

import java.math.BigInteger;
import java.util.List;

public class InstanceOfExample {

	public void test(){
		Object obj = new Object();
		if(null instanceof Object){ //totally legal somehow
			System.out.println("what???");
		}
		
		if(obj instanceof List<?>){
			System.out.println("it is possible for an object to be a list");
		}
		
		String s = new String();
		/*if(s instanceof List<?>){ 
			//NOT POSSIBLE beccause a String could never be a list
		}*/
		
		CharSequence c = new String();
		
		if(c instanceof String){
			System.out.println("it's a string!");
		}
		
		//This could never happen, so it doesn't compile
		/*if(c instanceof Boolean){
			
		}*/
		
		//IMPORTANT!!!!!
		//this is possible because a class COULD implement CharSequence and extend Number
		if(c instanceof Number){
			System.out.println("nope");
		}
		
		//This could never happen beccause Double is a FINAL class and cannot be extended
		/*if(c instanceof Double){
			
		}*/
		
		//this is possible again because BigInteger is not a final class and can be extended with an implementation of CharSequence
		if(c instanceof BigInteger){
			
		}
		
		CoolString cs = new CoolString();
		
		//cannot happen because CoolString is a class, not an interface and it doesn't extend from Number
		/*if(cs instanceof Number){
			
		}*/
		
		
		
	}
	
	class CoolString implements CharSequence{

		@Override
		public int length() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public char charAt(int index) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public CharSequence subSequence(int start, int end) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
