package org.anaolabs.java8.optionals;

import java.util.Optional;

import org.junit.Test;

/**
 * @formatter:off
 */
public class UsingOptional {
	
	@Test
	public void testOrElse() {
		
		// Optional avec valeur vide
		Optional<String> noName = Optional.empty();
		System.out.println( noName.orElse( "autre chose" ) );
	}
	
	@Test
	public void testGet() {
		
		// Optional avec valeur non vide
		Optional<String> frodo = Optional.of( "Frodon Baggins" );
		System.out.println( frodo.isPresent() );
		System.out.println( frodo.get() );
		
		frodo.ifPresent( ( s ) -> System.out.println( s ) );
	}
	
	@Test
	public void testOfNullable() {
		
		Optional<String> frodo = Optional.of( "Frodon Baggins" );
		Optional<String> sam = Optional.empty();
		Optional<String> pipin = null;
		
		System.out.println( frodo.ofNullable( frodo ) );
		System.out.println( frodo.ofNullable( sam ) );
		System.out.println( frodo.ofNullable( pipin ) );
	}
	
	@Test
	public void testFilter() {
		
		Optional<String> frodo = Optional.of( "Frodon Baggins" );
		Optional<String> sam = Optional.of( "Sam Gamegie" );
		
		System.out.println(
    		frodo
    			.filter( s -> s.startsWith( "Fro" ) )
    			.filter( s -> s.endsWith( "gins" ) )
    			.orElse( "DOES NOT MATCH" )
    	);
		
		System.out.println(
		           		sam
		           			.filter( s -> s.startsWith( "Fro" ) )
		           			.filter( s -> s.endsWith( "gins" ) )
		           			.orElse( "DOES NOT MATCH" )
		           	);

	}
	
}
