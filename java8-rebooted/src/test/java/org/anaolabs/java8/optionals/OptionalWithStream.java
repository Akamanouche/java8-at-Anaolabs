package org.anaolabs.java8.optionals;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * @formatter:off
 */
public class OptionalWithStream {
	
	@Test
	public void optionalInStream() {
		
		/* Autre forme :
		 * Arrays.asList( "a1", "a2", "a3" ).stream().findFirst().ifPresent( System.out::println );
		 */
		
		Stream.of( "a1", "a2", "a3" )
			.findFirst()
			.ifPresent( System.out::println );
		
	}
	
	@Test
	public void optionalEmptyInStream() {
		
		Stream.of( Optional.empty(), "a2", "a3" )
			.findFirst()
//			.orElse( "Empty element !!" )
			.ifPresent( System.out::println )
		;
	}
}
