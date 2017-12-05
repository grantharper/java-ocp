package com.functional;

import java.util.ArrayList;
import java.util.List;

public class MethodReferences
{

  public static void main(String[] args)
  {
    Food f = new Food("pizza");
    
    MethodReferences mr = new MethodReferences();
    
    mr.process(f);
    //Digestible is a functional interface
    mr.process((a) -> true);
    mr.process(f::eat);
  }
  
  public void process(Digestible d){
    System.out.println(d.eat(new ArrayList<Food>()));
  }
  
  
}

interface Digestible{
  static int provideHungerLevel(){return 1;}

  boolean eat(List<? extends Digestible> eats);
}

class Food implements Digestible{
  String name;
  
  public Food(String name){
    this.name = name;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @Override
  public boolean eat(List<? extends Digestible> eats)
  {
    return false;
  }
  
  
}


