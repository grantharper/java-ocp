package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByExample {

	public static void main(String[] args) {
		List<String> fruitList = Arrays.asList("apple", "orange", "cherry", "banana", "tangerine");
		Map<Boolean, List<String>> organizedFruit = fruitList.stream().collect(Collectors.groupingBy(s -> s.length() > 6));
		
		System.out.println(organizedFruit);
		
		//THIS IS SO COOL - don't need to deal with the final iteration issue
		String oneLine = fruitList.stream().collect(Collectors.joining(", "));
		System.out.println(oneLine);
		
		
	}
	
}
