package com.classtypes;

public class LocalInnerExample {

	private int instanceVar = 10;
	
	private static int static_var = 11;
	
	public void inner(){
		
		int shadowed = 1;
		int effectivelyFinal = 5;
		int notEffectivelyFinal = 1;
		notEffectivelyFinal += 3;
		
		class LocalInner{
			int one = 1;
			private int two = 2;
			static final int three = 3;
			//static int three = 3; DOES NOT COMPILE -- must be final
			public void print(){
				System.out.println(this.one);
				System.out.println(effectivelyFinal);
				//System.out.println(notEffectivelyFinal); DOES NOT COMPILE, not effectively final
				
				//has access to outer class instance variables (current instance) and static variables
				int example = LocalInnerExample.this.instanceVar;
				example = LocalInnerExample.static_var;
				
				LocalInnerExample lie = new LocalInnerExample(); //different instance of the outer class
				example = lie.instanceVar;
			}
		}
		
		
	}
}
