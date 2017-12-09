package com.generics;

public class GenericsExample <K, V>
{

  private K identity(K k){
    return k;
  }
  
  private <X> X identity1(X x){
    return x;
  }
  
}
