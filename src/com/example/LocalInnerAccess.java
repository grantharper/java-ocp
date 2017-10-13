package com.example;

public class LocalInnerAccess {

	
	public void isItFinal() {
		/*final*/ int one = 20;
		int two = one;
		two++;
		
		/*final*/int three;
		if(one==4) three = 3;
		else three = 4;
		
		int four = 4;
		
		class Inner{
			public void print(){
				System.out.println(one);
				//System.out.println(two); --does not compile
				System.out.println(three);
				//System.out.println(four); -- does not compile
			}
			
		}
		four = 5;
	}
}
