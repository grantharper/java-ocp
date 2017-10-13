package com.example;

import java.util.Map;

public class GenericFun {

	interface MyIn<T extends Map<?, ?>> {
		void foo();
	}

	class MyClass implements MyIn<Map> {
		/*
		 * this doesn't compile outside of eclipse javac -d bin
		 * src/com/example/GenericFun.java
		 *
		 * src\com\example\GenericFun.java:11: error: type argument Map is not
		 * within bounds of type-variable T class MyClass implements MyIn<Map>{
		 * ^ where T is a type-variable: T extends Map<?,?> declared in
		 * interface MyIn 1 error
		 */

		@Override
		public void foo() {

		}
	}

	public static void main(String args[]) {
		System.out.println("blah");
	}
}
