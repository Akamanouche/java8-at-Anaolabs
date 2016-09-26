package org.anaolabs.java8.monade.sample1;

import java.util.Optional;

public class Conference {
	private Integer id;
	private String title;
	private Speaker mainSpeaker;
	private Speaker secondarySpeaker;

	/*
	 * Private constructors
	 */
	private Conference(Integer id, String title, Speaker mainSpeaker,
			Speaker secondarySpeaker) {
		this.id = id;
		this.title = title;
		this.mainSpeaker = mainSpeaker;
		this.secondarySpeaker = secondarySpeaker;
	}
	private Conference(Integer id, String title, Speaker mainSpeaker) {
		this(id, title, mainSpeaker, null);
	}

	/*
	 * Static factory methods
	 */
	public static Conference of(Integer id, String title, Speaker mainSpeaker) {
		return new Conference(id, title, mainSpeaker);
	}
	public static Conference of(Integer id, String title, Speaker mainSpeaker,
			Speaker secondarySpeaker) {
		return new Conference(id, title, mainSpeaker, secondarySpeaker);
	}

	public Speaker getMainSpeaker() {
		return this.mainSpeaker;
	}

	public Optional<Speaker> getSecondarySpeaker() {
		return Optional.ofNullable(this.secondarySpeaker);
	}

	public static Optional<Conference> findById(Integer id) {
		
		// Ici acces à votre DB...
		switch (id) {
		case 100:
			// DISCLAIMER : ne pas utiliser .get()
			// ici il s'agit d'un exemple pour constuire une conf de test
			return Optional.of(Conference.of(100, "Scala for Beginner", Speaker.findById(888).get())); // juste Nicolas
					
		case 200:
			// DISCLAIMER : ne pas utiliser .get()
			// ici il s'agit d'un exemple pour constuire une conf de test
			return Optional.of(Conference.of(200,
					"Spring 4.1",
					Speaker.findById(777).get(), // Bob
					Speaker.findById(888).get()) // Nicolas est 2nd speaker
					);
		default:
			return Optional.empty();
		}
	}

	@Override
	public String toString() {
		return getSecondarySpeaker().map(
				localSecondarySpeaker -> String.format("Conference[%s] %s by %s and %s", this.id, this.title,this.mainSpeaker, localSecondarySpeaker))
				.orElse(String.format("Conference[%s] %s by %s", this.id, this.title,this.mainSpeaker));
	}
}
