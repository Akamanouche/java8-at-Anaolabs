package org.anaolabs.java8.streams.newuse.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 *
 * @formatter:off
 */
public class SortingCollections {
	
	@Test
	public void testSortMapInNewMap() {
	
		Map<Integer, Student> map = new HashMap<>();
		map.put( 1, new Student( "Kevin", 45  ) );
		map.put( 2, new Student( "Sylvain", 25 ) );
		map.put( 3,  new Student( "Matthieu", 50 ) );
		
		System.out.println( "# tri custom selon age Student..." );
		Map<Integer, Student> sortedMap = map.entrySet()
				.stream()
				.sorted((s1, s2) -> Integer.compare( s1.getValue().getAge(), s2.getValue().getAge() ))
				.collect( Collectors.toMap( 
				                           	Map.Entry::getKey, Map.Entry::getValue,
				                            (e1, e2) -> e1, LinkedHashMap::new      // !! ATTENTION !! Sans cela, le tri est perdu	
				                            ) );
		
		System.out.println( "# Display new map" );
		sortedMap.entrySet()
				.stream()
				.forEach( s -> {
							Integer key = (Integer)s.getKey();
							Student std = (Student)s.getValue();
							System.out.println( String.format( "\tstudent: id= %d, name: '%s', age= %d", key.intValue(), std.getName(), std.getAge() ) );
					}	
				);
		
	}
		
	@Test
	public void testSortMap() {
	
		Map<Integer, Student> map = new HashMap<>();
		map.put( 1, new Student( "Kevin", 45  ) );
		map.put( 2, new Student( "Sylvain", 25 ) );
		map.put( 3,  new Student( "Matthieu", 50 ) );
		
		/*
		 * Ceci lève une exception :
		 * 	java.lang.ClassCastException: java.util.HashMap$Node cannot be cast to java.lang.Comparable
		 *	at java.util.Comparators$NaturalOrderComparator.compare(Comparators.java:47)
		 * ...
		 */
//		map.entrySet()
//			.stream()
//			.sorted()
//			.forEach( s -> {
//				Integer key = (Integer)s.getKey();
//				Student std = (Student)s.getValue();
//				System.out.println( String.format( "\tstudent: id:%d', name: '%s', age: %d", key.intValue(), std.getName(), std.getAge() ) );
//			});
		
		System.out.println( "# tri naturel par key" );
		map.entrySet()
			.stream()
			.sorted(Comparator.comparing( Map.Entry::getKey ))
			.forEach( s -> {
				Integer key = (Integer)s.getKey();
				Student std = (Student)s.getValue();
				System.out.println( String.format( "\tstudent: id= %d, name: '%s', age= %d", key.intValue(), std.getName(), std.getAge() ) );
			});
		
		System.out.println( "# tri custom selon ordre naturel des objects Student" );
		map.entrySet()
			.stream()
			.sorted(Comparator.comparing( Map.Entry::getValue ))
			.forEach( s -> {
				Integer key = (Integer)s.getKey();
				Student std = (Student)s.getValue();
				System.out.println( String.format( "\tstudent: id= %d, name: '%s', age= %d", key.intValue(), std.getName(), std.getAge() ) );
			});
		
		System.out.println( "# tri custom selon age Student" );
		map.entrySet()
			.stream()
			.sorted((s1, s2) -> Integer.compare( s1.getValue().getAge(), s2.getValue().getAge() ))
			.forEach( s -> {
				Integer key = (Integer)s.getKey();
				Student std = (Student)s.getValue();
				System.out.println( String.format( "\tstudent: id= %d, name: '%s', age= %d", key.intValue(), std.getName(), std.getAge() ) );
			});

	}
	
	
	@Test
	public void testSortList() {
		
		List<Student> list = new ArrayList<Student>();
		list.add( new Student( "Kevin", 45 ) );
		list.add( new Student( "Sylvain", 25 ) );
		list.add( new Student( "Matthieu", 50 ) );
		
		// Tri selon donné par la méthode compareTo() de Student (= l'ordre naturel des String)
		System.out.println( "# tri naturel" );
		list.stream()
			.sorted()
			.collect( Collectors.toList() )
			.forEach( s -> {
				System.out.println( String.format( "\tstudent '%s', age: %d", s.getName(), s.getAge() ) );
			} );
		
		// Même chose qu'au-dessus, mais en tri inversé
		System.out.println( "# tri naturel inversé" );
		list.stream()
			.sorted(Comparator.reverseOrder())
			.collect( Collectors.toList() )
			.forEach( s -> {
				System.out.println( String.format( "\tstudent '%s', age: %d", s.getName(), s.getAge() ) );
			} );
		
		// Tri selon une autre ordre
		System.out.println( "# tri custom selon (age)" );
		list.stream()
			.sorted(Comparator.comparing( Student::getAge ))
			.collect( Collectors.toList() )
			.forEach( s -> {
				System.out.println( String.format( "\tstudent '%s', age: %d", s.getName(), s.getAge() ) );
			} );
		
		// Tri selon une autre ordre, mais inversé
		System.out.println( "# tri custom selon (age) mais inversé" );
		list.stream()
			.sorted(Comparator.comparing( Student::getAge ).reversed())
			.collect( Collectors.toList() )
			.forEach( s -> {
				System.out.println( String.format( "\tstudent '%s', age: %d", s.getName(), s.getAge() ) );
			} );

	}
}
