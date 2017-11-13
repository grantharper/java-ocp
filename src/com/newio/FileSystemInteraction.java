package com.newio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Collectors;

public class FileSystemInteraction {

	public static void main(String[] args) {
		try {
			System.out.println("List all java files in the directory src/com/assertions");
			Files.list(Paths.get("src/com/assertions")).filter(s -> s.toString().endsWith(".java"))
					.forEach(System.out::println);
			
			System.out.println("Find the current file executing this program");
			Files.find(Paths.get(""), 10, (p, a) -> p.toString().endsWith("FileSystemInteraction.java")).forEach(System.out::println);;
			
			System.out.println("List all java files in this project");
			Files.walk(Paths.get("")).filter(s -> s.toString().endsWith(".java")).forEach(a -> System.out.print(a + ";"));
			System.out.println();
			
			
			System.out.println("trying to use URI");
			Path p1 = Paths.get(new URI("file:///c:/personal/java-ocp/src/com/newio/FileSystemInteraction.java"));
			
			System.out.println(p1.getFileName());
			
			System.out.println("getting a file off a remote file system using http: doesn't work because it's not an actual file system");
			//FileSystem fs = FileSystems.getFileSystem(new URI("http://blog.grantharper.org"));
			//Path p2 = fs.getPath("software/2017/09/12/web-app-security.html");
			//System.out.println(Files.exists(p2));
			
			System.out.println("Read all lines of a file");
			
			Path thisFile = Paths.get("src/com/newio/FileSystemInteraction.java");
			
			List<String> allLines = Files.readAllLines(Paths.get("src/com/newio/FileSystemInteraction.java"));
			
			allLines.forEach(System.out::println);
			
			
			BasicFileAttributes attr = Files.readAttributes(thisFile, BasicFileAttributes.class);
			
			System.out.println("Creation time:" + attr.creationTime());
			
			System.out.println("Is regular file?" + attr.isRegularFile());
			System.out.println("Is directory?" + attr.isDirectory());
			System.out.println("Size (in bytes)" + attr.size());
			System.out.println("Last modified date/time:" + attr.lastModifiedTime());
			System.out.println("Last access date/time:" + attr.lastAccessTime());
			System.out.println("Uniqe file identifier (if available):" + attr.fileKey());
			
			Files.lines(thisFile).filter(a -> a.length() > 20).map(s -> s.length()).forEach(i -> System.out.print(i + ";"));
			
			System.out.println();
			System.out.println(Paths.get("..").toRealPath().toString());
			
			System.out.println("Moving a file: metadata is moved too");
			Path text = Paths.get("testdir", "text.txt");
			System.out.println("last modified time of text.txt: " + Files.getLastModifiedTime(text));
			Path something = Paths.get("testdir", "something.txt");
			Files.move(text, something);
			BasicFileAttributes bv = Files.readAttributes(something, BasicFileAttributes.class);
			System.out.println("last modified time of something.txt:" + bv.lastModifiedTime());
			
			//move bacck
			Files.move(something, text, StandardCopyOption.ATOMIC_MOVE);
			
			
			System.out.println("Normalize doesn't convert to absolute path");
			Path currentDir = Paths.get(".");
			System.out.println("current directory:" + currentDir);
			System.out.println("current directory name count:" + currentDir.getNameCount());
			System.out.println("current directory:" + currentDir.getName(0));
			
			
			//find with depth search
			System.out.println("Depth search experimentation: 1");
			Files.find(currentDir, 1, (p,a) -> true).map(p -> p.toString()).collect(Collectors.toList()).stream().forEach(i -> System.out.print(i + ";"));
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
