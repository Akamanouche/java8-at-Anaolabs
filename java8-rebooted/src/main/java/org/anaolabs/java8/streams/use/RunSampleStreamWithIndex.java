package org.anaolabs.java8.streams.use;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * La question ici est : Est-il possible de parser un Stream tout en ayant accès à l'index relatif de l'élément ?
 * 
 * "Is there a concise way to iterate over a stream whilst having access to the index in the stream ?..."
 * (https://stackoverflow.com/questions/18552005/is-there-a-concise-way-to-iterate-over-a-stream-with-indices-in-java-8)
 * 
 * @author t328469
 * @formatter:off
 *
 */
public class RunSampleStreamWithIndex {
	
	public static void main( String[] args ) {
		
		String[] names = { "Sam", "Pamela", "Dave", "Eva", "Erik", "Henry", "Elisa", "Agecanonichou" };
		
		// Filtrer les éléments dont la longueur est EXACTEMENT égal à l'indice dans le tableau
		System.out.println( "# Filtrer les éléments dont la longueur est EXATEMENT égal à l'indice dans le tableau" );
		IntStream.range( 0, names.length )
				.filter( i -> names[i].length() == i ) 
		        .mapToObj( i -> names[i] )
		        .collect( Collectors.toList() )
		        .forEach( elt -> {
			         System.out.println( "\t"+elt );
		         } );

		
		// Filtrer les éléments dont la longueur est SUPERIEUR à l'indice dans le tableau
		System.out.println( "# Filtrer les éléments dont la longueur est SUPERIEUR à l'indice dans le tableau" );
		IntStream.range( 0, names.length )
				.filter( i -> names[i].length() > i ) 
		        .mapToObj( i -> names[i] )
		        .collect( Collectors.toList() )
		        .forEach( elt -> {
			         System.out.println( "\t"+elt );
		         } );

	}
	
}
