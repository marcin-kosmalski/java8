package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import utils.Base;

public class FileTest extends Base {

	public static void main(String[] args) {
		new FileTest();
	}

	public FileTest() {

		listFiles();
		
		System.out.println("====dirs====");
		listDirs();
		System.out.println("====all====");
		listFilesWithExtension(".xml");
	}
	
	public void listFilesWithExtension(String extension){
		try {
			Files.newDirectoryStream(Paths.get("."),path->path.toString().endsWith(extension)).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void listDirs(){
		try {
			Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listFiles() {
		try {
			Files.list(Paths.get(".")).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
