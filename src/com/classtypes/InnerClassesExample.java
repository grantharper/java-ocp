package com.classtypes;

public class InnerClassesExample {
	
	private int five = 5;
	private static int SIX = 6;

	public class PubInner{
		private static final int ONE = 1;
		//static int two = 2; // DOES NOT COMPILE because it is not final
		private int three = 3;
		
		int four = 4;
		
		private int getThree(){
			return three;
		}
		
		protected int getFour(){
			return four;
		}
		
		public int getFive(){
			return new InnerClassesExample().five;
		}
	}
	
	
	public void getPubInnerVars(){
		PubInner pi = new PubInner();
		pi.getThree(); //accessible in this class file 
		System.out.println(pi.three); //accessible in this class file
		System.out.println(PubInner.ONE); //accessible through static context
		System.out.println(pi.ONE); //also accessible through instance, but not recommended
		
	}
	
	protected class ProtectedInner{
		
	}
	
	private class PrivateInner{
		private static final int ONE = 1;
		//static int two = 2; // DOES NOT COMPILE because it is not final
		private int three = 3;
		
		int four = 4;
		
		private int getThree(){
			return three;
		}
		
		protected int getFour(){
			return four;
		}
	}
	
	public void getPrivateInnerVars(){
		PrivateInner pi = new PrivateInner();
		pi.getThree(); //accessible in this class file 
		System.out.println(pi.three); //accessible in this class file
		System.out.println(PubInner.ONE); //accessible through static context
		System.out.println(pi.ONE); //also accessible through instance, but not recommended
		
	}
	
	class PackageInner{
		
	}
	
}
