package com.io;

import java.io.Console;

public class ConsolePractice {

	
	public static void main(String[] args) {
		
		Console c = System.console();
		
		if(c == null){
			//Eclipse does not support the console
			//From the root directory, enter the following in the terminal to run this (assumes compilation is already done)
			//java -cp ./bin com.io.ConsolePractice
			
			throw new RuntimeException("Console not supported");
		}else{
			
			String s = c.readLine("Enter something:");
			System.out.println("You entered: " + s);
			
			char[] pass = c.readPassword("Enter a password: ");
			System.out.println("Password: " + String.valueOf(pass));
		}
		
	}
}
