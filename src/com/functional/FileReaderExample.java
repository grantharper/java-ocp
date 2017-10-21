package com.functional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
	
	private static String fileName = "test.txt";
	
	public static String processFile(BufferedReaderProcessor p) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		return p.process(br);
	}

	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReaderProcessor brOneLine = br -> br.readLine();
		BufferedReaderProcessor brTwoLines = br -> {return br.readLine() + br.readLine();};
		
		

		System.out.println(processFile(brOneLine));
		System.out.println(processFile(brTwoLines));
	}
	
}
