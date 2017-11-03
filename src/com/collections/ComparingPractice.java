package com.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class ComparingPractice
{

  public static void main(String[] args)
  {
    Consumer<Collection<?>> print = System.out::println;
    
    Monster m1 = new Monster("ghost", 1);
    Monster m2 = new Monster("demon", 5);
    Monster m3 = new Monster("vampire", 4);
    
    System.out.println("As each monster is added to the tree set, they are ordered based on scare factor");
    Set<Monster> monsters = new TreeSet<>();
    monsters.add(m1);
    print.accept(monsters);
    monsters.add(m2);
    print.accept(monsters);
    monsters.add(m3);
    print.accept(monsters);
    //uses default order of arranging by scare factor upon insertion
    
    
    //defined a different compartor using anonymous inner class method
    Comparator<Monster> nameCompare = new Comparator<Monster>()
    {
      
      @Override
      public int compare(Monster o1, Monster o2)
      {
        return o1.getName().compareTo(o2.getName());
      }
    };
    
    //define using lambda
    nameCompare = (a, b) -> a.getName().compareTo(b.getName());
    
    List<Monster> monsterList = new ArrayList<>();
    monsterList.add(m2);
    monsterList.add(m3);
    monsterList.add(m1);

    Collections.sort(monsterList);
    System.out.println("Sorted by the default compareTo");
    print.accept(monsterList);
    
    Collections.sort(monsterList, nameCompare);
    System.out.println("Sorted by the comparator based on name");
    print.accept(monsterList);
    
  }
  
  
  
}

class Monster implements Comparable<Monster>{
  private String name;
  private Integer scareFactor;
  
  public Monster(String name, Integer scareFactor){
    this.name = name;
    this.scareFactor = scareFactor;
  }

  public String getName()
  {
    return name;
  }

  public Integer getScareFactor()
  {
    return scareFactor;
  }

  @Override
  public int compareTo(Monster o)
  {
    return this.scareFactor - o.scareFactor;
  }

  @Override
  public String toString()
  {
    return "Monster [name=" + name + "]";
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Monster other = (Monster) obj;
    if (name == null)
    {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
  
  
  
}
