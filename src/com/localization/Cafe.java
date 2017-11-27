package com.localization;

public class Cafe
{
  private String name;
  private double valuation;

  public Cafe(String name, double valuation)
  {
    super();
    this.name = name;
    this.valuation = valuation;
  }

  public String getName()
  {
    return name;
  }

  public double getValuation()
  {
    return valuation;
  }

  @Override
  public String toString()
  {
    return "Cafe [name=" + name + ", valuation=" + valuation + "]";
  }
}
