package com.classtypes;

public class InnerClassesExampleExtension extends InnerClassesExample {

	public void accessParentVars(){
		this.getPubInnerVars();
		InnerClassesExampleExtension ie = new InnerClassesExampleExtension();
		InnerClassesExample.PubInner pi = ie.new PubInner();
		//System.out.println(pi.ONE); DOES NOT COMPILE because of private level visibility
		System.out.println(pi.four);
		pi.getFour();
		
		//InnerClassesExample.PrivateInner ip= ie.new PrivateInner(); NOT ACCESSIBLE due to private visibility
		
		InnerClassesExample.ProtectedInner protin = ie.new ProtectedInner();
		InnerClassesExample.PackageInner packin = ie.new PackageInner();
		
	}
	
}
