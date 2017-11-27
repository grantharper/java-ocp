package com.collections;

import java.util.HashMap;
import java.util.Map;

public class MapExample
{

  public static void main(String[] args)
  {
    Map<Integer, String> map = new HashMap<>();
    
    map.put(1, "1");
    map.put(2, "2");
    System.out.println("Original map:" +  map);
    
    map.computeIfPresent(2, (k, v) -> v + "computeIfPresent" + (k + 1));
    
    System.out.println("After computeIfPresent update:" + map);
    
    map.compute(1, (k,v) -> v + "compute");
    
    System.out.println("After compute:" + map);
    
    map.computeIfAbsent(3, k -> "3");
    
    System.out.println("After computeIfAbsent:" + map);
    
    //map will first look at the hashcode to identify the bucket before using equals
    //this is why it is so important that the hashcode is the same for two objects that are equal
    Map<Phone, Integer> crazyPhones = new HashMap<>();
    MapExample mp = new MapExample();
    crazyPhones.put(mp.new Phone("AAA"), 1);
    crazyPhones.put(mp.new Phone("BBB"), 2);
    
    Phone phone = mp.new Phone("AAA");
    
    System.out.println(crazyPhones.get(phone));
    
    
  }
  
  
  class Phone{
    private String serial;
    public Phone(String serial){
      this.serial = serial;
    }
    public String getSerial()
    {
      return serial;
    }
    public void setSerial(String serial)
    {
      this.serial = serial;
    }
    @Override
    public int hashCode()
    {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + ((serial == null) ? 0 : serial.hashCode());
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
      Phone other = (Phone) obj;
      if (!getOuterType().equals(other.getOuterType()))
        return false;
      if (serial == null)
      {
        if (other.serial != null)
          return false;
      } else if (!serial.equals(other.serial))
        return false;
      return true;
    }
    private MapExample getOuterType()
    {
      return MapExample.this;
    }
    @Override
    public String toString()
    {
      return "Phone [serial=" + serial + "]";
    }
    
    
    
  }
}
