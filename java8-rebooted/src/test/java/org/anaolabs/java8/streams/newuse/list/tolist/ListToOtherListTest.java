package org.anaolabs.java8.streams.newuse.list.tolist;

import org.anaolabs.java8.streams.newuse.list.tolist.StatesForCountry.State;
import org.anaolabs.java8.utils.JacksonSerializer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Tests conversion from a primary list (of {@link StateCountryResource}) to another list (of {@link StatesForCountry})
 * 
 * @author t328469
 */
public class ListToOtherListTest {

    JacksonSerializer serializer = new JacksonSerializer();

    @Test
    public void testConversion() throws IOException {

        /* List of primary data */
        List<StateCountryResource> scrList;

        /* List of final data to forge */
        List<StatesForCountry> sfcList;

        // Get primary datas
        List<?> primaryData = serializer.deserialize("src/test/resources/data/gat-resource-StatesForCountries-primary-data.json", StateCountryResource.class);

        // Parse primary data
        scrList = (List<StateCountryResource>) primaryData;
        Assert.assertEquals(6, scrList.size());

        // Le Collectors.groupingBy() me renvoie une Map à partir de la List initiale
        System.out.println("\nSTEP1 : le Collectors.groupingBy() me renvoie une Map");
        scrList.stream()
            .collect(Collectors.groupingBy(scr -> scr.getCountryCode()))
            .entrySet()
            .stream()
            .forEach(scr -> System.out.println(String.format("\t - key (countryCode): %s || value: %s", scr.getKey(), scr.getValue())));

        // Il faut donc maintenant convertir la Map en une List...

        // SANS les infos de State (juste le countryCode)
        System.out.println("\nSTEP2 : on forge une List<StatesForCountry> SANS les infos de State ");
        sfcList = scrList.stream()
            .collect(Collectors.groupingBy(scr -> scr.getCountryCode()))
            .entrySet()
            .stream()
            .map(e -> new StatesForCountry(e.getKey(), null))
            .collect(Collectors.toList());

        sfcList.stream()
            .forEach(sfc -> System.out.println(String.format("\t - sfc (countryCode): %s", sfc.getCountryCode())));

        // Et maintenant: AVEC les infos de State
        System.out.println("\nSTEP3 : on forge une List<StatesForCountry> AVEC des infos de State");
        sfcList = scrList.stream()
            .collect(Collectors.groupingBy(scr -> scr.getCountryCode()))
            .entrySet()
            .stream()
            .map(e ->
                {
                    StatesForCountry sfc = new StatesForCountry();
                    sfc.setCountryCode(e.getKey());
                    sfc.setStates(e.getValue()
                        .stream()
                        .map(scrStateInfo -> new State(scrStateInfo.getStateCode(), scrStateInfo.getStateName()))
                        .collect(Collectors.toList()));
                    return sfc;
                })
            .collect(Collectors.toList());

        sfcList.stream()
            .forEach(sfc -> System.out.println(String.format("\t - sfc (countryCode): %s || states: %s", sfc.getCountryCode(), sfc.getStates())));

    }
}
