/**
 * java8-rebooted
 *
 * Copyright (c) Anaolabs
 */
package org.anaolabs.java8.streams.newuse.grouping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TooManyListenersException;
import java.util.stream.Collectors;

import org.anaolabs.java8.streams.newuse.Person;
import org.junit.Before;
import org.junit.Test;

/**
 * <Put some documentation here>
 *
 * @author Sylvain RICHET
 *
 */
public class GroupingTest {
	
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
	 * USE 1 :
	 * 		basique, grouper selon un critère sur l'OBJET sous-jacent
	 * 
	 * Par défaut la méthode: Collectors.groupingBy(...) renvoie une Map<critère, List<OBJET>>
	 */
	@Test
	public void groupBasic() {

		// Basic grouping
		Map<Integer, List<Person>> personsByAge = persons
				.stream()
				.collect(Collectors.groupingBy(p -> p.age))
				;

		// Check/Output
		personsByAge.forEach((age,person)-> System.out.println(String.format("age %d : %s", age, person)) );
	}


	/**
	 * USE 2 :
	 * 		plus compliqué, on modifie la liste dans la Map de retour
	 * 
	 * A la place d'avoir en retour une Map<Integer, List<Person>>, on a directement une : Map<Integer, List<String>>
	 * 
	 * # source : https://www.baeldung.com/java-groupingby-collector
	 */
	@Test
	public void groupModifyReturnedListType() {

		// Basic grouping
		Map<Integer, List<String>> personsByAge = persons
				.stream()
				.collect(Collectors.groupingBy(
						p -> p.age,
						Collectors.mapping(Person::getName, Collectors.toList())
						));

		// Check/Output
		personsByAge.forEach((age,name)-> System.out.println(String.format("age %d : %s", age, name)) );

	}
}
