package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamWrapping {

	
	public static void main(String[] args) throws IOException {
		
		
		InputStream is = new BufferedInputStream(new FileInputStream("test.txt"));
		
		OutputStream os = new BufferedOutputStream(new FileOutputStream("testcopy.txt"));
		byte[] b = new byte[1024];
		int length = 0;
		while((length = is.read(b, 0, 1024)) > 0){
			//System.out.println(b);
			os.write(b, 0, length);
			os.flush(); //this is very important. It may not write to disk if you don't do this
			if(length < 1024){
				break;
			}
		}
		
		
		
		
	}
}
