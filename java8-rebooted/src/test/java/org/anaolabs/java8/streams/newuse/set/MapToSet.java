package org.anaolabs.java8.streams.newuse.set;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author T328469
 * @formatter:off
 */
public class MapToSet {
	
	Map<String, String> map = new HashMap<>();
	
	@Before
	public void setup() {
		map.put( "AF1", "Air France" );
		map.put( "AF2", "Air France" );
		map.put( "KL", "Dutch KLM" );
		map.put( "DL", "Delta Airline" );
	}
	
	/*
	 * Ici on se contente de récupérer le Set depuis la Map
	 */
	@Test
	public void testGetSetFromMapAsIs() {
	
		map.values()
			.stream()
			.collect( Collectors.toSet() )
			.forEach( v -> System.out.println( "\t- "+v ) );
	}
	
	/*
	 * Ici on applique un petit traitement à chaque élément de la Map avant de récupérer le Set
	 */
	@Test
	public void testGetSetFromMapWithTransformation() {
	
	    Set<String> set = null;
	    
		set = map.values()
			.stream()
			.map( v -> v + "-enriched")
			.collect( Collectors.toSet() )
			;
		
		set.forEach( v -> System.out.println( "\t- "+v ) );
	}

}
