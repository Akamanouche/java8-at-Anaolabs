package org.anaolabs.java8.streams.use;

import java.util.stream.IntStream;

public class RunSample {

	public static void main(String[] args) {

//		IntStream.range(1, 5)
//	    .forEach(System.out::println);

		// map
		System.out.println("Map");
		
		IntStream.range(1, 5)
		.map(n -> n* 2 +1)
	    .forEach(System.out::println);
		
		
		// map + average
		System.out.println("Map + average");
		
		IntStream.range(1, 5)
		.map(n -> n* 2 +1)
		.average()
		.ifPresent(System.out::println);
		;
		
		
	}
}

