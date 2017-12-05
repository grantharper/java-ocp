package com.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Function;

public class StreamPractice
{

  public static Consumer<Character> printer = System.out::print;

  public static Function<Integer, Character> converter = i -> (char) i.intValue();

  public static void main(String[] args)
  {
    try (InputStream is = new BufferedInputStream(new FileInputStream(new File("test.txt"))))
    {

      char c;
      if (is.markSupported())
      {
        printer.accept(converter.apply(is.read()));
        is.mark(100);
        printer.accept(converter.apply(is.read()));
        printer.accept(converter.apply(is.read()));
        is.reset();
        printer.accept(converter.apply(is.read()));
        printer.accept(converter.apply(is.read()));

      }

      is.skip(5);

      int i = 0;

      while ((i = is.read()) != -1)
      {
        c = (char) i;
        System.out.print(c);
      }

    } catch (IOException e)
    {

      e.printStackTrace();
    }

    try (InputStream is = new BufferedInputStream(new FileInputStream(new File("test.txt"))))
    {
      System.out.println("\nattempt at reading into byte array");
      byte[] barr = new byte[100];
      is.read(barr, 0, 100);

      for (byte b : barr)
      {
        System.out.print((char) b);
      }

    } catch (FileNotFoundException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.println();
    
    System.out.println("input stream reader that wraps the file input stream");
    try (FileInputStream fis = new FileInputStream(new File("test.txt"));
        InputStreamReader is = new InputStreamReader(fis))
    {
     
      while(is.ready()){ //ready method is pretty convenient to avoid the weird assignment and then check logic
        int i = is.read();
        char c = (char) i;
        System.out.print(c);
      }
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    

  }

}
