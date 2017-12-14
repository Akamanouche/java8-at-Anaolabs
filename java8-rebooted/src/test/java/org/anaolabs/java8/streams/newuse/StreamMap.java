/**
 * 
 */
package org.anaolabs.java8.streams.newuse;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

/**
 * @see: http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 * 
 * @author t328469
 *
 */
public class StreamMap {

	List<Person> persons = null;
	
	@Before
	public void before() {
		persons = Arrays.asList(
				new Person("Boris", 12),
				new Person("Max", 18),
				new Person("Peter", 23),
				new Person("Pamela", 23),
				new Person("David", 12));
	}

	/**
	 * USE 1 : Transformer une liste avec .map()
	 */
	@Test
	public void map() {
		Map<Integer, String> map = persons
			    .stream()
			    .collect(Collectors.toMap(
			        p -> p.age,
			        p -> p.name,
			        (name1, name2) -> name1 + ";" + name2));

		// Display
		System.out.println(map);		// {18=Max, 23=Peter;Pamela, 12=Boris;David}
	}
}
