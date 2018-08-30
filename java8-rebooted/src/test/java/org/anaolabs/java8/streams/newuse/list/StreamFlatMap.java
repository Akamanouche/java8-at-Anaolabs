/**
 * 
 */
package org.anaolabs.java8.streams.newuse.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.anaolabs.java8.streams.newuse.Bar;
import org.anaolabs.java8.streams.newuse.Foo;
import org.junit.Before;
import org.junit.Test;

/**
 * @see: http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 * 
 * Objectif :
 * We've already learned how to transform the objects of a stream into another type of objects by utilizing the map operation.
 * Map is kinda limited because every object can only be mapped to exactly one other object.
 * But what if we want to transform one object into multiple others or none at all ?
 * 
 * ==> This is where flatMap comes to the rescue.
 * 
 * @author t328469
 *
 */
public class StreamFlatMap {

	List<Foo> foos = null;
	
	@Before
	public void before() {
		
		foos = new ArrayList<>();
		
		// forge a list of foos 
		IntStream
		.range(1, 4)
		.forEach(i -> foos.add(new Foo("Foo#"+i)));
		
		// populate bars on foos
		foos.forEach(f -> IntStream
				.range(1,3)
				.forEach(i -> f.bars.add(
						new Bar(String.format("Bar%d/of/%s", i, f.name))
						)
				));
		
		// Display
		System.out.println(String.format("Foos list: %s",foos));
		
	}

	/**
	 * USE 1 : Transformer une liste avec .map() en une autre
	 */
	@Test
	public void map() {
		
		/* A partir de la liste des "Foo" (qui contiennent des "Bar") :
		 * on va extraire une liste de tous les "Bar"
		 */
		Stream<Bar> allBars = foos.stream().flatMap(f -> f.bars.stream());
	    
		// Display
		System.out.println("Extracted list of Bar(s):");
		allBars.forEach(b -> System.out.println(b.name));

	}
}
