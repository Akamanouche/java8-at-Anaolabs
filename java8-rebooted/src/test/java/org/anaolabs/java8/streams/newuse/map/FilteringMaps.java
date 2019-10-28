/**
 * 
 */
package org.anaolabs.java8.streams.newuse.map;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Inpiré de MyKong : > https://www.mkyong.com/java8/java-8-filter-a-map-examples/
 * 
 * @formatter:off
 * @author t328469
 *
 */
public class FilteringMaps {
	
    Map<Integer, String> map = null;
    
	@Before
	public void setup() {
		
		map = new HashMap<>();
		map.put( 1, "linode" );
		map.put( 2, "heroku" );
		map.put( 3, "bitbucket" );
		map.put( 4, "atlassian" );
		map.put( 5, "bitbucket" );
		map.put( 6, "bitly" );
	}
	
    ///////////////////////////////////////////////////
    // Map -> Stream -> Filter -> String
    ///////////////////////////////////////////////////
	@Test
	public void filterToString() {

		String result = map.entrySet()
				.stream()
				.filter( x -> "bitbucket".equals( x.getValue() ) )
				.map( x -> x.getKey().toString() )
				.collect( Collectors.joining() );
		
		// Dispslay result
		System.out.println( String.format( "Result 1 : %s %s", result, System.lineSeparator() ));
	}
	

    ///////////////////////////////////////////////////
    // Map -> Stream -> Filter -> Map
    ///////////////////////////////////////////////////
    @Test
    public void filterToMap() {
        
        Map<Integer, String> collectedMap = map.entrySet()
                .stream()
                .filter(x -> x.getValue().startsWith( "bit" ))
                //.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));       // autre forme
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));     // forme plus parlante
        
        // Display result
//        System.out.println( "Result 2");
//        collectedMap.entrySet().forEach( e -> {
//            System.out.println( String.format( "\t%s:%s", e.getKey(), e.getValue() ));
//        } );
        
        // ou encore :
        collectedMap.entrySet().forEach( e -> doIt(e) );
    }


    ///////////////////////////////////////////////////
    // Map -> Stream -> Map updated
    // (no filtering here..., just update)
    ///////////////////////////////////////////////////
    @Test
    public void justUpdatingMap() {
        
        Map<Integer, String> updatedMap = null;
        
        // Apply changes and collect
        updatedMap = map.entrySet()
                .stream()
                .collect(Collectors.toMap( e -> e.getKey(), e -> updateEntry(e.getValue()) ) );
        
        // Print
        updatedMap.entrySet().forEach( e -> {
            System.out.println( String.format( "\t%s:%s", e.getKey(), e.getValue() ));
        } );

    }

    ///////////////////////////////////////////////////
    // Map -> Stream -> Map value : change of type
    ///////////////////////////////////////////////////
    @Test
    public void transformValue() {
        Map<String, String> m1 = new HashMap<>();
        m1.put("1", "ONE");
        m1.put("2", "TWO");
        
        // ************************************************************************************************************
        // Ce qui suit ne compile pas !
        //  ==> Erreur : "Type mismatch: cannot convert from Map<Object,Object> to Map<Integer,String>"
        //
        // Alors que de nombreux exemples fonctoionnent ailleurs :
        //  > https://www.techiedelight.com/transform-hashmap-java-8/
        //  > ...
        // ************************************************************************************************************

        Map<Integer, String> m2 = m1
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                    e -> Integer.parseInt(e.getKey()),
                    e -> e.getValue()));
        
        m2.entrySet()
        .stream()
        .forEach(e -> {System.out.println(String.format("Integer: %d", e.getKey()));});

    }
    
    
    
	///////////////////////////////////////////////////////////////////////////
	// Some utils function
	///////////////////////////////////////////////////////////////////////////
	private void doIt(Map.Entry<Integer, String> entry) {
		System.out.println( String.format( "Just do it with entry:  %s:%s", entry.getKey(), entry.getValue()));
	}
	
    private String updateEntry(String entry) {
        // Just uppercasing 
        return entry.toUpperCase();
    }

}
