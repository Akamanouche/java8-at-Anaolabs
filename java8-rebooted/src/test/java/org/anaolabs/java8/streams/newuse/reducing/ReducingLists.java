package org.anaolabs.java8.streams.newuse.reducing;

import java.util.Arrays;
import java.util.List;

import org.anaolabs.java8.streams.newuse.Person;
import org.junit.Before;
import org.junit.Test;

/**
 * Inspiré de :
 * 		> https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/#reduce
 *
 * @author T328469
 * @formatter:off
 */
public class ReducingLists {

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
	 * USE 1 : qui est le plus agé ?
	 */
	@Test
	public void reduceToOldestPerson() {
		persons
	    	.stream()
	    	.reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
	    	.ifPresent(System.out::println);
		
		// should print: Pamela
	}

	/**
	 * USE 2 :
	 * 		Hybrider ceux dont le nom commence par 'P'
	 * 		On utilise ici un Accumulator
	 */
	@Test
	public void reduceToOneHybrid() {
		Person hybrid = persons
	    	.stream()
	    	.filter( p -> p.name.startsWith( "P" ) )
	    	.reduce( new Person("ThisIsAnHybrid:", 0), (p1, p2) -> {
	    		p1.age += p2.age;
	    		//p1.name.concat( p2.name );
	    		p1.name += p2.name;
	    		return p1;
	    	});
		
		System.out.format("name=%s; age=%s", hybrid.name, hybrid.age);
		// should print: name=ThisIsAnHybrid:PeterPamela; age=46
	}

}
