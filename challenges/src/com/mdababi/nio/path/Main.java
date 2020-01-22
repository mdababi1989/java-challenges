package com.mdababi.nio.path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
//		Path path = FileSystems.getDefault().getPath("src/com/mdababi/nio/path", "testFile.txt");
		Path path = Paths.get(".", "src/com/mdababi/nio/path", "testFile.txt"); 
		if(Files.exists(path)) {
			System.out.println("exits");
		}
		else 
			System.out.println("try another path");
		Path copyPath = Paths.get(".", "src/com/mdababi/nio/path", "copytFile.txt"); 
		;
		try(OutputStream out= Files.newOutputStream(copyPath)) {
			Files.copy(path, out);
			//Files.move(path, copyPath);
			// Files.delete(copyPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printFile(path);
		
		
		
		System.out.println();
	}
	
	public static void printFile(Path path) {
		try(BufferedReader bufferedReader = Files.newBufferedReader(path)){
			String line = null;
			while((line=bufferedReader.readLine())!=null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
