package com.functional;

import java.util.function.Predicate;

public class PredicatePractice {

	static Predicate<String> first = String::isEmpty;
	static Predicate<String> second = "Magic word"::equals;
	static Predicate<String> or = first.or(second);
	static Predicate<String> and = first.and(second);
	static Predicate<String> notEmpty = first.negate();
	
	public static void main(String[] args) {
		
		System.out.println("Or with [Magic word]: " + or.test("Magic word"));
		System.out.println("And with []: " + and.test("")); //pay attention to the short-circuiting here
		System.out.println("notEmpty with [a]: " + notEmpty.test("a"));
	}
	
}
