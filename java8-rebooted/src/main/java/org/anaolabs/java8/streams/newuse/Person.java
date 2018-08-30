/**
 * 
 */
package org.anaolabs.java8.streams.newuse;

/**
 * @see: http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 * 
 * @author t328469
 *
 */
public class Person {
	
	public String name;
	public int	  age;
	
	public Person( String name, int age ) {
		
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		
		return name;
	}
}