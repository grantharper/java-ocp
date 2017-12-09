package com.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsPractice
{

  public static void main(String[] args)
  {
    List<String> letters = Arrays.asList("a", "b", "c", "d");

    letters.stream()
           .collect(HashSet::new, (t, r) -> t.add(r), (t, r) -> t.add(r));

    System.out.println(letters);

    CollectorsPractice cp = new CollectorsPractice();
    List<Beer> beers = Arrays.asList(cp.beerCreator.apply("Optimal Wit"), cp.new Beer("Monumental IPA"), cp.new Beer("Pumpkick"));

    Set<Beer> beerSet = beers.stream().collect(Collectors.toSet());
    System.out.println(beerSet);
    
    Long numberOfBeers = beers.stream().collect(Collectors.counting());
    
    System.out.println("number of beers=" + numberOfBeers);
    
    double averagePrice = beers.stream().collect(Collectors.averagingDouble(Beer::getPrice));
    System.out.println("average price=" + averagePrice);
    
    List<String> beerNames = beers.stream().collect(Collectors.mapping(Beer::getName, Collectors.toList()));
    System.out.println("beer names=" + beerNames);
  }
  
  private Function<String, Beer> beerCreator = Beer::new;

  class Beer
  {

    private String name;
    private double price;

    public double getPrice()
    {
      return price;
    }

    public void setPrice(double price)
    {
      this.price = price;
    }

    public Beer(String name)
    {
      this.name = name;
      this.price = 6.0;
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
    public String toString()
    {
      return "Beer [name=" + name + "]";
    }
    
    public int hashCode(){
      return 31 * name.length();
    }
    
    @Override
    public boolean equals(Object o){
      if(o instanceof Beer){
        Beer b = (Beer) o;
        if(b.name.equals(this.name)){
          return true;
        }
      }
      return false;
    }
    
    

  }

}
