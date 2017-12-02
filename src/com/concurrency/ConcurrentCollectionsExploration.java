package com.concurrency;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.SynchronousQueue;

public class ConcurrentCollectionsExploration {

	
	List<Integer> stuffList = new CopyOnWriteArrayList<>();
	Set<Integer> stuffSet = new ConcurrentSkipListSet<>();
	List<Integer> stuffSyncList;
	
	{
		List<Integer> backingList = Arrays.asList(1, 2, 3, 4); //fyi, you can't add to a list that is created this way. You will get UnsupportedOperationException
		stuffList.addAll(backingList);
		stuffSet.addAll(backingList);
		stuffSyncList = Collections.synchronizedList(backingList);
	}
	
	public static void main(String[] args) {
		ConcurrentCollectionsExploration cce = new ConcurrentCollectionsExploration();
		for(Integer i: cce.stuffList) cce.stuffList.add(4);
		int x = 5;
		for(Integer i: cce.stuffSet) cce.stuffSet.add(5); //this one updates the list as it loops through, but because it is a set, it only loops 5 times because of the unique value constraint
		//if you had a different value being inserted every time, this would run infinitely
		
		for(Integer i: cce.stuffSyncList) System.out.println("blah");//cce.stuffSyncList.add(5);
		
		System.out.println("listSize=" + cce.stuffList.size() + ", setSize=" + cce.stuffSet.size());
	}
	
}
