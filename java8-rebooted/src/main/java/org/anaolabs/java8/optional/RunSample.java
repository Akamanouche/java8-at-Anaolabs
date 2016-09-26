package org.anaolabs.java8.optional;

import java.util.Optional;

public class RunSample {

	public static void main(String[] args) {

		// Optional avec valeur vide
		Optional<String> noName = Optional.empty();
		System.out.println(noName.orElse("autre chose"));

		// Optional avec valeur non vide
		Optional<String> frodo = Optional.of("Frodon Baggins");
		System.out.println(frodo.isPresent());
		System.out.println(frodo.get());
		
		frodo.ifPresent((s) -> System.out.println(s));

	}
}

