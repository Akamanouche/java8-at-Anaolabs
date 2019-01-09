/**
 * Anaolabs / anaolabs-java-overall
 *
 * Copyright (c) Anaolabs
 */
package org.anaolabs.java8.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Lecture/Ecriture de fichier savec le JDK 7.
 *
 * Utilisation des classes du package  java.nio :
 * - l'interface {@link Path}
 * - la classe {@link Files}
 *
 *	Avant le JDK 7, l'API java.io et notamment la classe File présentait de nombreux désavantages
 *	(voir Doudoux,: http://www.jmdoudoux.fr/java/dej/chap-nio2.htm#nio2-1)
 *	Donc :
 *	- Exit la classe File !
 *	- Welcome Path, Files, ... !
 *
 * @formatter:off
 */
public class ReadWriteFile {

	///////////////////////////////////////////////////////////////////////////
	// Methods for "small" files
	///////////////////////////////////////////////////////////////////////////
	
	public List<String> readSmallFile(String filepath) throws IOException {
		
		// Obtenir une instance de Path à partir du path exprimé sous forme de string
		Path path = Paths.get(filepath);
		
		/*
		 * Javadoc says :
		 * "
		 * Note that this method is intended for simple cases where it is convenient to read all lines in a single operation.
		 * It is not intended for reading in large files.
		 * "
		 */
		return Files.readAllLines(path);
	}
	

	
    public String readSmallFileOneShot(String filepath) throws IOException {
        Path path = Paths.get(filepath);
        
        return new String( Files.readAllBytes(path), "UTF-8"); 
        
    }
	
	
	///////////////////////////////////////////////////////////////////////////
	// Methods for "large" files
	///////////////////////////////////////////////////////////////////////////
	
	public void readLargeFileAsString(String filepath) throws IOException {
		
		// Obtenir une instance de Path à partir du path exprimé sous forme de string
		Path path = Paths.get(filepath);

		// Using Scanner in a try-with-resource
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())) {
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				doSomething(line);
			}
		}
	}
	
	public void readLargeFileAsInt(String filepath) throws IOException {
		
		// Obtenir une instance de Path à partir du path exprimé sous forme de string
		Path path = Paths.get(filepath);

		// Using Scanner in a try-with-resource
		try (Scanner scanner =  new Scanner(path, StandardCharsets.UTF_8.name())) {
			while (scanner.hasNext()) {
				int integer = scanner.nextInt();
				doSomething(String.valueOf(integer));
			}
		}
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	// Local helper
	///////////////////////////////////////////////////////////////////////////
	
	/*
	 * Fake method to handle each line of a large file 
	 */
	private void doSomething(String line) {
		System.out.println(line);
	}
	
}
