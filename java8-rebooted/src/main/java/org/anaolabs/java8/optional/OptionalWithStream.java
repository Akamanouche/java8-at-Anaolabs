package org.anaolabs.java8.optional;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalWithStream {

	public static void main(String[] args) {

		// basics();
		optionalInStream();
	}

	@SuppressWarnings("unused")
	private static void basics() {

		// Optional avec valeur vide
		Optional<String> noName = Optional.empty();
		System.out.println(noName.orElse("autre chose"));

		// Optional avec valeur non vide
		Optional<String> frodo = Optional.of("Frodon Baggins");
		System.out.println(frodo.isPresent());
		System.out.println(frodo.get());

		frodo.ifPresent((s) -> System.out.println(s));
	}

	private static void optionalInStream() {
		Arrays.asList("a1", "a2", "a3")
		.stream()
		.findFirst()
		.ifPresent(System.out::println);	/* glop glop ! */
		
		Stream.of("a1", "a2", "a3")
		.findFirst()
		.ifPresent(System.out::println);	/* glop glop ! */

	}
}
