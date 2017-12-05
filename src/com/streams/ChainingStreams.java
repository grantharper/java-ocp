package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class ChainingStreams
{
  enum Roast
  {
    LIGHT,
    MEDIUM,
    DARK
  }

  public static void main(String[] args)
  {
    ChainingStreams cs = new ChainingStreams();
    List<ChainingStreams.Coffee> coffeeList = Arrays.asList(cs.new Coffee(Roast.DARK, 2.0),
        cs.new Coffee(Roast.LIGHT, 2.1), cs.new Coffee(Roast.MEDIUM, 1.9));

    OptionalDouble avgPriceGourmet = coffeeList.stream().filter(a -> a.getPrice() > 1.9).map(ChainingStreams.Coffee::getPrice).mapToDouble(a -> a).average();
    
    System.out.println(avgPriceGourmet.getAsDouble()); //2.05
  }

  class Coffee
  {

    private Roast roast;
    private double price;

    public Coffee(Roast roast, double price)
    {
      this.roast = roast;
      this.price = price;
    }

    public Roast getRoast()
    {
      return roast;
    }

    public void setRoast(Roast roast)
    {
      this.roast = roast;
    }

    public double getPrice()
    {
      return price;
    }

    public void setPrice(double price)
    {
      this.price = price;
    }

  }

}
