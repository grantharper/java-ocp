package com.enums.other;

import com.enums.EnumExample;

public class OutsideClass {

	public static void main(String[] args) {
		EnumExample.FALL.play();
		//EnumExample.FALL.stupid(); //NOT VISIBLE from outside of the package
		
		EnumExample.SPRING.play();
		//EnumExample.SPRING.stupid(); //NOT VISIBLE even though stupid() has public visibility declared in the actual implementation
		
		EnumExample e = EnumExample.SPRING;
		
	}
	
}
