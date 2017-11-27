package com.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationPractice
{
  
  private static final String FILE_NAME = "coffee.txt";

  public static void main(String[] args)
  {
    System.out.println("Coffee before serialization");
    Coffee c1 = new Coffee.CoffeeBuilder().setOrigin("columbia").setProcess("washed").setRoast("medium").setTemperature(80).build();
    System.out.println(c1);
    
    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
     
      oos.writeObject(c1);
      
    } catch (FileNotFoundException e)
    {
      e.printStackTrace();
    } catch (IOException e)
    {
      e.printStackTrace();
    }
    
    
    System.out.println("Coffee after serialization");

    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
      
      Coffee c2 = (Coffee) ois.readObject();
      
      System.out.println(c2);
      
    } catch (FileNotFoundException e)
    {
      e.printStackTrace();
    } catch (IOException e)
    {
      e.printStackTrace();
    } catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    
  }
  
}

class Coffee implements Serializable{
  
  private static final long serialVersionUID = 5460354612305025974L;
  
  private final String process;
  private final String origin;
  private final String roast;
  private final transient Integer temperature; //not serialized because it is transient
  
  private Coffee(String process, String origin, String roast, Integer temperature){
    this.process = process;
    this.origin = origin;
    this.roast = roast;
    this.temperature = temperature;
  }

  public String getProcess()
  {
    return process;
  }

  public String getOrigin()
  {
    return origin;
  }

  public String getRoast()
  {
    return roast;
  }
  
  public Integer getTemperature()
  {
    return temperature;
  }

  



  @Override
  public String toString()
  {
    return "Coffee [process=" + process + ", origin=" + origin + ", roast=" + roast + ", temperature=" + temperature
        + "]";
  }





  public static class CoffeeBuilder{
    private String process;
    private String origin;
    private String roast;
    private Integer temperature;
    
    public Coffee build(){
      return new Coffee(this.process, this.origin, this.roast, this.temperature);
    }
    
    public CoffeeBuilder setProcess(String process)
    {
      this.process = process;
      return this;
    }
    public CoffeeBuilder setOrigin(String origin)
    {
      this.origin = origin;
      return this;
    }
    public CoffeeBuilder setRoast(String roast)
    {
      this.roast = roast;
      return this;
    }
    
    public CoffeeBuilder setTemperature(Integer temperature)
    {
      this.temperature = temperature;
      return this;
    }
    
    
  }
  
}
