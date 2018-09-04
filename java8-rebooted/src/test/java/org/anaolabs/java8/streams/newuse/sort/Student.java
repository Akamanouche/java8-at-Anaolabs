package org.anaolabs.java8.streams.newuse.sort;

/**
 *
 */
public class Student implements Comparable<Student> {
	
	private String name;
	private int	   age;
	
	public Student( String name, int age ) {
		
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo( Student obj ) {
		
		return name.compareTo( obj.getName() );
	}
	
	///////////////////////////////////////////////////////////////////////////
	// Identification methods
	///////////////////////////////////////////////////////////////////////////
	
	@Override
	public int hashCode() {
		
		int hashno = 7;
		hashno = 13 * hashno + ( name == null ? 0 : name.hashCode() );
		return hashno;
	}
	
	@Override
	public boolean equals( Object obj ) {
		
		if ( obj == null ) {
			return false;
		}
		
		final Student std = (Student) obj;
		if ( this == std ) {
			return true;
		} else {
			return ( this.name.equals( std.name ) && ( this.age == std.age ) );
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	// Getters
	///////////////////////////////////////////////////////////////////////////
	
	public String getName() {
		
		return name;
	}
	
	public int getAge() {
		
		return age;
	}
	
}
