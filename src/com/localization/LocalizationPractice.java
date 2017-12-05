package com.localization;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationPractice
{

  public static void main(String[] args)
  { 
    Locale notUsedLocale = new Locale("blah", "fakeCountry");
    System.out.println("fakeLocale=" + notUsedLocale);
    String baseName = "messages";
    Locale locale = Locale.getDefault();
    System.out.println("Local.getDefault()=" + locale);
    ResourceBundle rb = ResourceBundle.getBundle(baseName, locale);
    iterateBundle(rb);
    rb = ResourceBundle.getBundle(baseName, Locale.CANADA_FRENCH);
    iterateBundle(rb);
    System.out.println("if we try to get prop5 out of french resource bundle it throws exception because the property doesn't exist in the tree of fr to default. Default locale isn't looked at since the property file is found:");
    System.out.println("try to get prop4 out of french resource bundle from java file: " + rb.getString("prop4"));

    System.out.println("using the the nifty object retrieval from localization");
    Cafe c = (Cafe) rb.getObject("cafe");
    System.out.println(c);
  }

  private static void iterateBundle(ResourceBundle rb)
  {
    Enumeration<String> e = rb.getKeys();
    while(e.hasMoreElements()){
      String key = e.nextElement();
      try{
      System.out.println(key + "=" +  rb.getString(key));
      }catch(ClassCastException ex){
        //swallow for demo purposes since Cafe object can't be cast to String
      }
      
      
    }
  }
  
}
