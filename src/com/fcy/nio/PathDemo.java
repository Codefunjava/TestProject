package com.fcy.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;

public class PathDemo {
	public static void main(String[] args) throws IOException {
		Path dir = Paths.get("D:\\Program Files");
//		DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
//		for (Path entry : stream) {
//			System.out.println(entry.getFileName());
//		}
		Files.walkFileTree(dir, new SimpleFileVisitor<Path>(){
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if(file.toString().endsWith(".bmp")){
					System.out.println(file.getFileName());
				}
				System.out.println(file.toString());
				return FileVisitResult.CONTINUE;
			}
		});
		
		AtomicInteger i = new AtomicInteger(0);
		i.incrementAndGet();
		
	}
	
}
