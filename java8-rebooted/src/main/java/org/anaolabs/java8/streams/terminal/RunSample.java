package org.anaolabs.java8.streams.terminal;

import java.util.Arrays;
import java.util.stream.Stream;

public class RunSample {

	public static void main(String[] args) {

		/* 
		 * filter() n'est pas suivi d'une opération TERMINALE
		 * Elle ne sera donc pas exécutée.
		 * Donc rien ne s'affichera
		 * 
		 * Remarque :
		 * On voit aussi qu'ici, on peut mettre n'importe quelle lambda dans filter()
		 * ... même une lambda qui ne filtre pas (println)
		 */
		System.out.println("# No terminal operation : filter() not exectuted");
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	    	System.out.println("filter: " + s);
	        return true;
	    });
		
		/* 
		 * filter() : suivi d'une opération TERMINALE, forEach()
		 * ==> filter() sera bien exécutée.
		 */
		System.out.println("# filter() exectuted while followed by a terminal operation");
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	    	System.out.println("filter: " + s);
	        return true;
	    })
	    .forEach(e -> System.out.println(String.format("forEach: %s", e)));
	    ;
		
	}
}

