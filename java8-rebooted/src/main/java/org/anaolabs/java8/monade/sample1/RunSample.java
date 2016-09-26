package org.anaolabs.java8.monade.sample1;

import java.util.Optional;

public class RunSample {

	public static void main(String[] args) {
//		run1();
//		response1();
		response2();
	}
	
	private static void run1() {
		System.out.println(Conference.findById(100));
		System.out.println(Conference.findById(200));
		System.out.println(Conference.findById(4444));
	}
	
	// Question : Comment feriez-vous pour afficher les références du deuxième speaker de n’importe quelle conférence ?
	// Réponse 1 : maladroite
	
	private static void response1() {
		Optional<Conference> maybeConference = Conference.findById(200);
		if (maybeConference.isPresent()) {
		    Conference conf = maybeConference.get(); // Possible mais franchement dommage...
		Optional<Speaker> maybeSecondarySpeaker = conf.getSecondarySpeaker();
		    if (maybeSecondarySpeaker.isPresent()) {
		        Speaker secondarySpeaker = maybeSecondarySpeaker.get();
		        Optional<String> maybeReference = secondarySpeaker.getReferences();
		        if (maybeReference.isPresent()) {
		            String references = maybeReference.get();
		            System.out.println(references);
		        }
		    }
		}
	}
	
	// Question : Comment feriez-vous pour afficher les références du deuxième speaker de n’importe quelle conférence ?
	// Réponse 2 : élégante
	
	private static void response2() {
		
		// Elégant :
		Conference.findById(200)
	        .flatMap(c -> c.getSecondarySpeaker())
	        .flatMap(s2 -> s2.getReferences())
	        .ifPresent(System.out::println);

		// Encore plus élégant :		
		Conference.findById(200)
	    .flatMap(Conference::getSecondarySpeaker)
	    .flatMap(Speaker::getReferences)
	    .ifPresent(System.out::println);

		// Pas de "secondarySpeaker" sur la conference 100 : rien ne sera en sortie		
		Conference.findById(100)
	    .flatMap(Conference::getSecondarySpeaker)
	    .flatMap(Speaker::getReferences)
	    .ifPresent(System.out::println);

	}
	
	
}
