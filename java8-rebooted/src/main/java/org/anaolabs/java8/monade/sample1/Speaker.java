package org.anaolabs.java8.monade.sample1;

import java.util.Optional;

public class Speaker {
	private Integer id;
	private String name;
	private String references;

	/*
	 * Private constructors
	 */
	private Speaker(Integer id, String name, String references) {
		this.id = id;
		this.name = name;
		this.references = references;
	}
	private Speaker(Integer id, String name) {
		this(id, name, null);
	}

	/*
	 * Static factory methods
	 */
	public static Speaker of(Integer id, String name, String references) {
		return new Speaker(id, name, references);
	}
	public static Speaker of(Integer id, String name) {
		return new Speaker(id, name, null);
	}

	public String getName() {
		return this.name;
	}

	public Optional<String> getReferences() {
		return Optional.ofNullable(this.references);
	}

	public static Optional<Speaker> findById(Integer id) {
		
		// Ici acces à votre DB...
		switch (id) {
		case 888:
			return Optional.of(Speaker.of(888, "Nicolas","Speaker Devoxx France 2014"));
		case 777:
			return Optional.of(Speaker.of(777, "Bob"));
		case 444:
			return Optional.of(Speaker.of(444, "John"));
		default:
			return Optional.empty();
		}
	}

	@Override
	public String toString() {
		return getReferences().map(
				someReferences -> String.format("Speaker[%s] %s with references %s", this.id,this.name, someReferences))
				.orElse(String.format("Speaker[%s] %s with no references", this.id,this.name));
	}
}
