package com.mdababi.ionio.nio.walktree;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		System.out.println("-------------------------walking directory------------");
		Path path = FileSystems.getDefault().getPath(".");
		
		
		try {
			Files.walkFileTree(path, new PrintNames());
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
		
		
		
	}

}
