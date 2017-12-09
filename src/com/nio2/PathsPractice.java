package com.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsPractice
{

  public static void main(String[] args) throws IOException
  {
    Path p1 = Paths.get("../../a/b.txt");
    Path p2 = Paths.get("./c.txt");
    
    System.out.println("p1.realitivize(p2)");
    System.out.println(p1.relativize(p2)); // ../../../.././c.txt -->does not clean up even though /./ doesn't mean anything
    System.out.println("normalized");
    System.out.println(p1.relativize(p2).normalize()); // ../../../../c.txt --> cleaned up
    System.out.println("p2.relativize(p1)");
    System.out.println(p2.relativize(p1)); // ../../../a/b.txt
    
    
    System.out.println("p1.resolve(p2)");
    System.out.println(p1.resolve(p2)); // ../../a/b.txt/./c.txt
    
    System.out.println("p2.resolve(p1)");
    System.out.println(p2.resolve(p1)); // ./c.txt/../../a/b.txt
    
    System.out.println("resolve with absolute path as starting point");
    System.out.println(Paths.get("c:/a/b/c").resolve(p1));
    System.out.println("resolve with absolute path as input parameter returns just the absolute");
    System.out.println(p1.resolve(Paths.get("c:/a/b/c")));
    
    Path p3 = Paths.get("c:\\test\\test1.txt");
    Path p4 = Paths.get("c:\\test\\test2.txt");
    Path p5 = p3.resolveSibling("test2.txt");
    System.out.println("After resolving sibling, the paths are the same:" + Files.isSameFile(p4, p5));
    
  }
  
  
}
