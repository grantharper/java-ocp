package com.collections;

import java.util.HashMap;
import java.util.Map;

public class MapHashCodeIssue
{

  Map<Book, Integer> books = new HashMap<>();
  
  public static void main(String[] args)
  {
    MapHashCodeIssue mh = new MapHashCodeIssue();
    
    Book b = new Book("War and Peace");
    
    mh.books.put(b, 10);
    System.out.println("Initial=" + mh.books.get(b));
    b = new Book("War and Peace");
    System.out.println("New Object=" + mh.books.get(b)); //null, but no exception is thrown
    
  }
  
}

class Book{
  private String title;
  
  Book(String title){
    this.title = title;
  }
  
  public boolean equals(Object o){
    return (o instanceof Book && ((Book) o).title.equals(this.title));
  }
}