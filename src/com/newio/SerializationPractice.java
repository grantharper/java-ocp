package com.newio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationPractice
{
  
  //a few reminders
  //if a class implements serializable, all the composing objects must also implement serializable in order for serialization to work
  //errors with serialization implementation will not be caught until runtime
  //if you can't implement serializable, you can implement private readObject(ObjectInputStream os) and private writeObject(ObjectOutputStream os)
  
  private static final String STATE_FILE = "serialstate.dat";

  public static void main(String[] args)
  {

    try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(STATE_FILE)))
    {
      Something s = new Something();
      s.setId(1);
      s.setName("lame");
      System.out.println("before serialization:" + s);
      os.writeObject(s);// the object is added to the stream twice, but it is
                        // still the same object
      os.writeObject(s);
      os.flush();

    } catch (FileNotFoundException e2)
    {
      e2.printStackTrace();
    } catch (IOException e2)
    {
      e2.printStackTrace();
    }

    try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(STATE_FILE)))
    {
      Something s1 = (Something) is.readObject();

      Something s2 = (Something) is.readObject(); // the object was written to
                                                  // the file twice, when it is
                                                  // read back it still points
                                                  // to the same object in
                                                  // memory
      s2.setId(2); // this change is made to the object referenced by s1 and s2

      System.out.println("after serialization and deserialization copy 1:" + s1); // id=2

      System.out.println("after serialization and deserialization copy 2:" + s2); // id=2

    } catch (FileNotFoundException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e1)
    {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch (ClassNotFoundException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}

class SomethingElse{

  @Override
  public String toString()
  {
    return "SomethingElse [toString()=" + super.toString() + "]";
  }
  
  
}

class Something implements Serializable
{

  private static final long serialVersionUID = -7666761044493158699L;

  private String name;
  private int id;
  private transient SomethingElse se;
  //private SomethingElse se; //if not transient, at runtime it will throw  java.io.NotSerializableException: com.newio.SomethingElse
  
  public Something(){
    this.se = new SomethingElse();
  }

  public SomethingElse getSe()
  {
    return se;
  }

  public void setSe(SomethingElse se)
  {
    this.se = se;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  @Override
  public String toString()
  {
    return "Something [name=" + name + ", id=" + id + ", se=" + se + "]";
  }

 

}
