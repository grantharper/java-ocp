package com.designpatterns;

public class ExternalBuilderUse {

	public static void main(String[] args) {
		BuilderPattern b = new BuilderPattern.BuilderPatternBuilder().setId(1).setName("Grant").build2();
		
		System.out.println(b);
	}
	
}
