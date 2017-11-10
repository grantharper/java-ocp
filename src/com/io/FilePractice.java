package com.io;

import java.io.File;

public class FilePractice
{

  public static void main(String[] args)
  {
    File test = new File("test.txt");
    
    if(test.exists()){
      System.out.println("getName=" + test.getName());
      System.out.println("getAbsolutePath=" + test.getAbsolutePath());
      System.out.println("isFile=" + test.isFile());
      System.out.println("isDirectory=" + test.isDirectory());
      System.out.println("length=" + test.length());
      System.out.println("lastModified=" + test.lastModified());
    }
    
    //create a new folder structure and move test.txt into it
    File dir = new File("newdir");
    System.out.println("Success creating newdir=" + dir.mkdir());
    
    File rename = new File("newdir/testrename.txt");
    
    System.out.println("Success renaming test.txt" + test.renameTo(rename));
    
    for(File f: dir.listFiles()){
      System.out.println(f.getName());
    }
    
    System.out.println("getParent=" + rename.getParent());
    rename.renameTo(test);
    dir.delete();
    
    
  }
  
  
}
