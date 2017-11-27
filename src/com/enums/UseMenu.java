package com.enums;

import java.util.TreeSet;

enum Menu
{

  CAPPUCCINO, LATTE, CORTADO, MACCHIATO;
  
}

public class UseMenu{
  public static void main(String[] args)
  {
    
    System.out.print("Value of method:");
    Menu m = Menu.valueOf("LATTE");
    System.out.println(m);
    
    System.out.print("values method, then loop through: ");
    for(Menu x: Menu.values()){
     System.out.print(x.name() +":" + x.ordinal() + ", "); 
    }
    
    System.out.println();
    
    TreeSet<Menu> enumSet = new TreeSet<>();
    for(Menu x: Menu.values()){
      enumSet.add(x);
    }
    System.out.println("Enums implement comparable so they can be sorted like in this TreeSet and are sorted by ordinal:");
    System.out.println(enumSet);
    
    System.out.println("If you use valueOf with an incorrect String you get an IllegalArgumentException");
    
    try{
      Menu.valueOf("blahblah");
    }catch(IllegalArgumentException e){
      e.printStackTrace();
    }
    
  }
}
