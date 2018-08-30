/**
 * 
 */
package org.anaolabs.java8.streams.newuse.list;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.anaolabs.java8.streams.newuse.Person;
import org.junit.Before;
import org.junit.Test;

/**
 * @see: http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 * 
 *       Objectif : We've already learned how to transform the objects of a stream into another type of objects by
 *       utilizing the map operation. Map is kinda limited because every object can only be mapped to exactly one other
 *       object. But what if we want to transform one object into multiple others or none at all ?
 * 
 *       ==> This is where flatMap comes to the rescue.
 * 
 * @author t328469
 *
 */
public class StreamListTokenizedToObjectMap {
	
	List<String> personsAsStr = null;
	
	@Before
	public void before() {
		
		personsAsStr = new ArrayList<>();
		
		// forge a list of foos
		IntStream.range( 1, 4 ).forEach( i -> personsAsStr.add( String.format( "person-%d:%d", i, i * 10 ) ) );
		
		// Display
		// System.out.println( String.format( "Persons (as Str) list: %s", personsAsStr ) );
	}
	
	@Test
	public void testToListStatic() {
		
		List<Person> persons = personsAsStr.stream().map( personAsStr -> {
			return new Person( "zozo", 10 );
		} ).collect( Collectors.toList() );
		
		// Display
		System.out.println( String.format( "Persons (as List): %s", persons ) );
	}
	
	@Test
	public void testToListOfObject() {
		
		Pattern p = Pattern.compile( ":" );
		
		//		personsAsStr.stream()
		//		            .forEach( personAsStr -> p.splitAsStream( personAsStr )
		//		                                      .forEach( token -> System.out.println( token ) ) );
		
		personsAsStr.stream().forEach( person -> {
			Stream.of( person.split( ":" ) ).forEach( z -> {
				System.out.println( z );
			} );
		} );
	}
	
}
