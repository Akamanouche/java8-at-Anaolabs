package org.anaolabs.java8.optionals;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

/**
 * ... find a workaround to :
 * comment filtrer une Collection (ou un Stream) null AVANT de la parser avec un Stream ?
 * 
 * @author t328469
 */
public class OptionalOnCollection {

    /**
     * RAPPEL PRELIMINAIRE :
     * ==> "foreach" raises a NullPointerException if List is null;
     */
    //@Test(expected = NullPointerException.class)
    @Test
    public void testForOnNullList() {

        // Null collection
        List<String> claims = null;

        // Ceci lève une NullPointerException
        claims.stream().forEach( c -> System.out.println(c));

        // Ici aussi !
        for (String claim : claims) {
            System.out.println("claim is " + claim);
        }
    }

    /**
     * Ici on implémente le workaround pour parser une Collection susceptible d'être NULL
     * (voir mise en relief du NullPointerException ci-dessus)
     */
    @Test
    public void testForOnNullListWithOptional() {
        // Null collection
        List<String> claims = null;
        //List<String> claims = Arrays.asList("un", "dexu");

        // No NullPointerException raised here
        Optional.ofNullable(claims)
            .map(Collection::stream)
            .orElseGet(Stream::empty)
            .forEach(c -> System.out.println(c));

        // Plus élégant :
        Optional.ofNullable(claims)
            //.orElse(Collections.emptyList())
            .orElse(Arrays.asList("empty list !"))
            .stream()
            .forEach(c -> System.out.println(c));

    }

}
