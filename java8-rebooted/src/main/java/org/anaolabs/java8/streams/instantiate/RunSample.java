package org.anaolabs.java8.streams.instantiate;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RunSample {

	public static void main( String[] args ) {

		Arrays.asList( "a1", "a2", "a3" )
		      .stream()
		      .forEach( p -> System.out.println( p ) );

		Arrays.asList( "a1", "a2", "a3" )
		      .parallelStream()
//		.forEach(p -> System.out.println(p))
		;

		Stream.of( "a1", "a2", "a3" )
//		.forEach(p -> System.out.println(p))
		;

		/**
		 * Streams d'entiers
		 */

		Arrays.stream( new int[] { 10, 2, 15, 50 } )
//		.forEach(p -> System.out.println(p))
		;

		IntStream.of( 10, 2, 15, 50 )
//		.forEach(p -> System.out.println(p))
		;

		IntStream.range( 1, 10 )
//		.forEach(p -> System.out.println(p))
		;

	}
}
