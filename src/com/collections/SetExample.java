package com.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

	
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		final TreeSet<Integer> s = new TreeSet<>();
		TreeSet<Integer> subs = new TreeSet<>();
		for (int i = 324; i <= 328; i++) {
			s.add(i);
		}
		
		subs = (TreeSet<Integer>) s.subSet(326, true, 340, true); //you can specify beyond what exists in parent
		s.add(333);
		s.add(341);
		subs.add(340);
		//subset the elements get added in both directions from sublist to parent and from parent to sublist
		
		System.out.println(s);
		System.out.println(subs);
		
		TreeSet<NonComparable> nonCompareSet = new TreeSet<>(new Comparator<NonComparable>() {

			@Override
			public int compare(NonComparable o1, NonComparable o2) {
				
				return 0;
			}
			
		});
		
		
	}
	
	class NonComparable {
		
		private int value;
		
		public NonComparable(int value){
			this.value = value;
		}
		
		
		
	}
	
}
