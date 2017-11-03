package com.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SortingExample implements Comparable<SortingExample>, Comparator<SortingExample>
{

  private int num;
  private String name;

  public SortingExample(int num, String name)
  {
    this.num = num;
    this.name = name;
  }
  
  @Override
  public String toString(){
    return "" + num;
  }

  public static void main(String[] args)
  {
    
    SortingExample s1 = new SortingExample(1, "B");
    SortingExample s2 = new SortingExample(2, "A");
    
    TreeSet<SortingExample> t1 = new TreeSet<>();
    t1.add(s1);
    t1.add(s2);
    System.out.println(t1);
    
    TreeSet<SortingExample> t2 = new TreeSet<>(s1); //signature here is TreeSet(Comparator<? super SortingExample> c)
    //this means that objects will be sorted according to their comparator
    t2.add(s1);
    t2.add(s2);
    System.out.println(t2);
    
    
    Set<String> sortingSet = new TreeSet<>();

    sortingSet.add("one");
    sortingSet.add("One");
    sortingSet.add("ONE");
    // sortingSet.add("On");

    System.out.println(sortingSet);

    TreeSet<String> treeSet = (TreeSet<String>) sortingSet;
    System.out.println(treeSet.ceiling("On"));
  }

  @Override
  public int compare(SortingExample o1, SortingExample o2)
  {
    
    return o1.num - o2.num;
  }

  @Override
  public int compareTo(SortingExample o)
  {

    return this.name.compareTo(o.name);
  }
}
