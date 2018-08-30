/**
 * 
 */
package org.anaolabs.java8.streams.newuse.map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Inpiré de MyKong : > https://www.mkyong.com/java8/java-8-filter-a-map-examples/
 * 
 * @formatter:off
 * @author t328469
 *
 */
public class FilteringMaps {
	
	@Test
	public void filter() {
		
		Map<Integer, String> map = new HashMap<>();
		map.put( 1, "linode" );
		map.put( 2, "heroku" );
		map.put( 3, "bitbucket" );
		map.put( 4, "atlassian" );
		map.put( 5, "bitbucket" );
		map.put( 6, "bitly" );

		///////////////////////////////////////////////////
		// 1) Map -> Stream -> Filter -> String
		///////////////////////////////////////////////////

		String result = map.entrySet()
				.stream()
				.filter( x -> "bitbucket".equals( x.getValue() ) )
				.map( x -> x.getValue() )
				.collect( Collectors.joining() );
		
		// Dispslay result
		System.out.println( String.format( "Result 1 : %s %s", result, System.lineSeparator() ));
		
		///////////////////////////////////////////////////
		// 2) Map -> Stream -> Filter -> Map
		///////////////////////////////////////////////////
		Map<Integer, String> collectedMap = map.entrySet()
				.stream()
				.filter(x -> x.getValue().startsWith( "bit" ))
				//.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));		// autre forme
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));		// forme plus parlante
		
		// Display result
		System.out.println( "Result 2");
		collectedMap.entrySet().forEach( e -> {
			System.out.println( String.format( "\t%s:%s", e.getKey(), e.getValue() ));
		} );
		
		// ou encore :
		collectedMap.entrySet().forEach( e -> doIt(e) );
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	// Some utils function
	///////////////////////////////////////////////////////////////////////////
	private void doIt(Map.Entry<Integer, String> entry) {
		System.out.println( String.format( "Just do it with entry:  %s:%s", entry.getKey(), entry.getValue()));
	}
	
}
