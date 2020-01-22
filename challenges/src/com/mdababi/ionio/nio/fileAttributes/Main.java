package com.mdababi.ionio.nio.fileAttributes;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Path fileToCreate = FileSystems.getDefault().getPath(".", "src/com/mdababi/nio/fileAttributes",
				"fileToCreate.txt");
		Path dirToCreate = FileSystems.getDefault().getPath(".", "src/com/mdababi/nio/fileAttributes", "dirToCreate");
		/*
		 * try { //Files.createFile(fileToCreate); Files.createDirectory(dirToCreate); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		try {
			long size = Files.size(fileToCreate);
			System.out.println(size);
			BasicFileAttributes attributes = Files.readAttributes(fileToCreate, BasicFileAttributes.class);
			System.out.println("size:" + attributes.size());
			System.out.println("creationTime: " + attributes.creationTime());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(FileSystems.getDefault().getSeparator());
		
		FileSystems.getDefault().getSeparator();

		/******************** read existing directory content **************/
		Path directoryPath = FileSystems.getDefault().getPath(".");
		try (DirectoryStream<Path> content = Files.newDirectoryStream(directoryPath)) {// accept filter as a second
																						// parameter
			for (Path file : content) {
				System.out.println(file.getFileName());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
