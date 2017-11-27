package com.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileManagement
{

  
  public static void main(String[] args)
  {
    
    Path path1 = Paths.get("a/b/c/d");
    Path sampleFile = path1.resolve(Paths.get("sample.txt"));
    
    Path sampleFileOther = path1.subpath(0, 2).resolve(Paths.get("sample.txt"));
    try
    {
      Files.createDirectories(path1);
      
      Files.createFile(sampleFile);
      
      Files.move(sampleFile, sampleFileOther, StandardCopyOption.REPLACE_EXISTING);
      
    } catch (IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
}
