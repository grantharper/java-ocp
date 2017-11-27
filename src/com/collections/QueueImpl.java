package com.collections;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueImpl
{

  public static void main(String[] args)
  {
    Queue<String> queue = new LinkedList<>();
    queue.add("a");
    queue.offer("b");
    System.out.println("First in line:" + queue.poll());
    
    Queue<String> priorityQueue = new PriorityQueue<>();
    for(int i = 0; i< 11; i++){
      priorityQueue.add("a");
    }
    
    
  }
  
}
