package com.newio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class Writing {

	public static void main(String[] args) throws IOException {
		//Files.newBufferedWriter(Paths.get("lame.txt"), StandardOpenOption.APPEND).append("\nthis is super lame").close();
		
		//System.out.println("number of lame lines=" + Files.lines(Paths.get("lame.txt")).filter(s -> s.contains("lame")).count());
		
		//potential way to read in a smallish file and add replace a given line
		Path propFilePath = Paths.get("app.props");
		
		List<String> propFileLines = Files.readAllLines(Paths.get("app.props"));
		
		propFileLines = propFileLines.stream().map(s -> {if(s.startsWith("encrypted.password=")){return "encrypted.password=updatedpassword";}else return s;}).collect(Collectors.toList());
		
		Files.write(propFilePath, propFileLines, StandardOpenOption.CREATE);
		
	}
	
}
