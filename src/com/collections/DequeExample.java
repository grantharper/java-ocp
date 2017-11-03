package com.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class DequeExample {
	
	
	
	public static void main(String[] args)
  {
	  Queue<String> queue = new ArrayDeque<>();
	  
	  boolean add = queue.add("1"); //will return true or throw exception based on success
	  queue.add("2");
	  System.out.println(add);
	  boolean offer = queue.offer("3"); //will return true or false based on success
	  System.out.println(offer);
	  System.out.println(queue);
	  
	  //for methods not in the queue interface
	  Deque<String> deque = (Deque<String>) queue;
	  deque.push("0"); //adds to front of queue
	  System.out.println(deque);
	  
	  //returns the first element and throws exception if empty queue
	  String firstElement = queue.element();
	  System.out.println(firstElement);
	  System.out.println(queue);
	  Queue<String> emptyQueue = new ArrayDeque<>();
	  try{
	    emptyQueue.element();
	  }catch(Exception e){
	    System.out.println(e);
	  }
	  
	  //actually removes the first element and returns it or throws exception if empty queue
	  
	  firstElement = queue.remove();
	  System.out.println(firstElement);
	  System.out.println(queue);
	  try{
      emptyQueue.remove();
    }catch(Exception e){
      System.out.println(e);
    }
	  
	  
	  
	  //returns next element or null if empty
	  String secondElement = queue.peek();
	  System.out.println(secondElement);
	  System.out.println(queue);
	  
	  //remove and returns next element or returns null if empty queue
	  secondElement = queue.poll();
	  System.out.println(secondElement);
	  System.out.println(queue);
	  
	  //pop removes from the front and throws an exception if it is an empty queue
	  String thirdElement = deque.pop();
	  System.out.println(thirdElement);
	  System.out.println(deque);
	  
  }

	
	
	
}
