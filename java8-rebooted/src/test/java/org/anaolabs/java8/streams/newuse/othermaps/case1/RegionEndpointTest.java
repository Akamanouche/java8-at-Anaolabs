package org.anaolabs.java8.streams.newuse.othermaps.case1;

import org.anaolabs.java8.streams.newuse.othermaps.case1.model.City;
import org.anaolabs.java8.streams.newuse.othermaps.case1.model.RegionDetailResource;
import org.anaolabs.java8.utils.JacksonSerializer;
import org.anaolabs.java8.utils.ReadWriteFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author T328469
 */
public class RegionEndpointTest {

	JacksonSerializer serializer = new JacksonSerializer();
	
    @Test
    public void testData() throws IOException {
    	
    	// Get it as Object
        List<Object> regionDetails = serializer.deserialize("src/test/resources/data/gat-resource-regionDetails-partial.json", RegionDetailResource.class);

        Assert.assertEquals(2, regionDetails.size());

        // 1: OK
        // List<Country> countries = regionDetails.stream()
        // .flatMap(rd -> ((RegionDetailResource) rd).getCountries().stream())
        // .collect(Collectors.toList());
        //
        // countries.forEach(c ->
        // {
        // System.out.println(String.format("\tCountry: %s", c.getCountryCode()));
        // });

        // 2: OK
        List<City> cities = regionDetails
            // Collect all countries
            .stream()
            .flatMap(rd -> ((RegionDetailResource) rd).getCountries().stream())
            .collect(Collectors.toList())
            // Collect all cities
            .stream()
            .flatMap(c -> c.getCities().stream())
            .collect(Collectors.toList());
//        cities.forEach(c ->
//            {
//                System.out.println(String.format("\tCity iataCode: %s", c.getIataCode()));
//                c.getAirports().forEach(a -> System.out.println(String.format("\t\tAirport iataCode: %s", a.getIataCode())));
//            });

        
        /*
         *  Tentatives - START
         *  
         *  Sources d'inspiration ?
         *  	> https://stackoverflow.com/questions/36271008/java-8-mapping-to-sub-list-entries-of-a-collection-using-streams-and-collectors
         */

        // Tentatives - END
        
        
        // 3 : OK
        // c regionDetails
        // // Collect all countries
        // .stream()
        // .flatMap(rd -> ((RegionDetailResource) rd).getCountries().stream())
        // .collect(Collectors.toList())
        // // Colect all cities
        // .stream()
        // .flatMap(co -> co.getCities().stream())
        // .collect(Collectors.toList())
        // // Collect all Airports
        // .stream()
        // .flatMap(ci -> ci.getAirports().stream())
        // .collect(Collectors.toList());
        // airports.forEach(a ->
        // {
        // System.out.println(String.format("\tAirport: %s", a.getIataCode()));
        // });

        // List<CityAirport> airportsCities = regionDetails
        // // Collect all countries
        // .stream()
        // .flatMap(rd -> ((RegionDetailResource) rd).getCountries().stream())
        // .collect(Collectors.toList())
        // // Colect all cities
        // .stream()
        // .flatMap(co -> co.getCities().stream())
        // .collect(Collectors.toList())
        // // Collect all Airports vs Cities
        // .stream()
        // .flatMap(ci -> ci.getAirports().stream())
        // .collect(Collectors.toList());

        // List<Airport> airports = null;
        // airports.stream().filter(a -> a.getIataCode() == "AGF").collect(Collectors.toList());

    }

    /**
     * Class mapping Airports to Cities
     */
    private class AirportCity {

        private final String iataCode;

        private final String cityCode;

        public AirportCity(String iataCode, String cityCode) {
            this.iataCode = iataCode;
            this.cityCode = cityCode;
        }

    }
}
