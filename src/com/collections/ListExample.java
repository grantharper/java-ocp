package com.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample {

	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		
		List<String> sublist = list.subList(1, 3);
		
		sublist.add("E");
		sublist.remove("C");
		list.add("F"); //when you do this it makes the sublist inaccessible
		
		System.out.println(list);
		System.out.println(sublist);
	}
	
}
