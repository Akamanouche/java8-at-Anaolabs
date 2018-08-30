/**
 * 
 */
package org.anaolabs.java8.streams.newuse;

import java.util.ArrayList;
import java.util.List;

/**
 * @see: http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 * 
 * @author t328469
 *
 */
public class Foo {
	
	public String	 name;
	public List<Bar> bars = new ArrayList<>();
	
	public Foo( String name ) {
		
		this.name = name;
	}
	
	@Override
	public String toString() {
		
		return String.format( "%s: %s", name, bars );
	}
	
}
