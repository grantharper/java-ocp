package com.classtypes;

import java.io.IOException;
import java.sql.SQLException;

public class InheritanceExceptions implements I1, I2
{
  
  int i1;

  @Override
  public void m1() // doesn't declare any new or broader exceptions, so it's ok
                   // (no exceptions)
  {

  }

  @Override
  public void m2() throws IOException
  {

  }

  @Override
  public void m3()
  {
    I1.super.m3();
  }

}

interface I1
{
  void m1() throws IOException;

  void m2() throws IOException;
  
  default void m3(){
    System.out.println("I1-M3");
  }
}

interface I2
{
  void m1() throws SQLException;
  
  default void m3(){
    System.out.println("I2-M3");
  }
}
