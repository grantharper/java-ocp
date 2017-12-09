package com.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

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
    
    
    System.out.println("blah");
  }
  
  public void something(){
    Function<Food, Boolean> f = (Food a) -> Boolean.TRUE;
    
    Function<Food, Boolean> g = Food::something; //ok because it is static
    
    Function<Food, Boolean> h = Food::nonStaticSomething; //ok because the nonStaticSomething signature has no input parameter. It acts on the object itself
    
    ToIntFunction<String> s = String::length;
    
  }
  
  public void process(Digestible d){
    System.out.println(d.eat(new ArrayList<Food>()));
    "".length();
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
  
  public static Boolean something(Food f){
    return Boolean.TRUE;
  }
  
  public Boolean nonStaticSomething(){
    return Boolean.FALSE;
  }
  
  
}


