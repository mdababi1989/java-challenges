package com.mdababi.nio.path;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
		Path path = FileSystems.getDefault().getPath("");
		System.out.println(path);
		
		// TODO Auto-generated method stub

	}

}
