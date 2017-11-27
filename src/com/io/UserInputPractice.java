package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UserInputPractice {

	public static void main(String[] args) throws IOException {
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		        ){
		  bw.write("input some data:");
		  bw.flush();
		  String userInput = br.readLine();
		  bw.write("your input:" + userInput);
		  bw.flush();
		  
		  System.out.println();
	    System.out.println("Reading from file");
	    
	    try(BufferedReader fr = new BufferedReader(new FileReader("test.txt"))){
	      String firstLine = fr.readLine();
	      System.out.println(firstLine);
	    }
		  
		}
		
		//because System.out is in the above try with resources block, the print writer is closed and no more output will be printed to console
		
		System.out.println("will not be printed to console");
		
		
		
	}
	
	
}
