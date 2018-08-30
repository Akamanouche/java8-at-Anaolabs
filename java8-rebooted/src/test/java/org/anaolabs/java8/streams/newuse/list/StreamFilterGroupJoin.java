/**
 * 
 */
package org.anaolabs.java8.streams.newuse.list;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.anaolabs.java8.streams.newuse.Person;
import org.junit.Before;
import org.junit.Test;

/**
 * @see: http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 * 
 * @author t328469
 *
 */
public class StreamFilterGroupJoin {

	List<Person> persons = null;
	
	@Before
	public void before() {
		persons = Arrays.asList(
				new Person("Max", 18),
				new Person("Peter", 23),
				new Person("Pamela", 23),
				new Person("David", 12));
	}

	/**
	 * USE 1 : Extraire une liste filtrée
	 */
	@Test
	public void usingCollectorsWithFilter() {
		List<Person> filtered = persons
	        .stream()
	        .filter(p -> p.name.startsWith("P"))
	        .collect(Collectors.toList());

		// ==> Pour avoir un Set : utiliser Collectors.toSet() !

		// Display
		System.out.println(filtered);
	}
	
	/**
	 * USE 2 : Grouper selon un critère
	 * 
	 * ==> On utilise la méthode: Collectors.groupingBy(...)
	 */
	@Test
	public void groupAccordingCriteria() {

		Map<Integer, List<Person>> personsByAge = persons
				.stream()
				.collect(Collectors.groupingBy(p -> p.age))
				;

		// Display
		personsByAge.forEach((age,person)-> System.out.println(String.format("age %d : %s", age, person)) );
	}

	/**
	 * USE 3 : Extraire une moyenne
	 * 
	 * ==> On utilise la méthode: Collectors.averagingInt(...)
	 */
	@Test
	public void getAnAverrage() {

		Double averageAge = persons
				.stream()
				.collect(Collectors.averagingInt(p -> p.age));
		
		// Display
		System.out.println(String.format("average = %s", averageAge));
	}
	

	/**
	 * USE 4 : joindre des éléments dans un unique String 
	 * 
	 * ==> On utilise la méthode: Collectors.joining(...)
	 */
	@Test
	public void getGatherInPhrase() {

		String phrase = persons
			    .stream()
			    .filter(p -> p.age > 15)
			    .map(p -> p.name)
			    .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

		// Display
		System.out.println(phrase);
	}

}
