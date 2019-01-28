package org.anaolabs.java8.streams.newuse.othermaps.case1;

import org.anaolabs.java8.streams.newuse.othermaps.case1.model.Airport;
import org.anaolabs.java8.streams.newuse.othermaps.case1.model.City;
import org.anaolabs.java8.streams.newuse.othermaps.case1.model.RegionDetailResource;
import org.anaolabs.java8.utils.JacksonSerializer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        List<?> regionDetails = serializer.deserialize("src/test/resources/data/gat-resource-regionDetails-partial.json", RegionDetailResource.class);

        Assert.assertEquals(2, regionDetails.size());

        // 1: FlatMap des Countries / OK
        // List<Country> countries = regionDetails.stream()
        // .flatMap(rd -> ((RegionDetailResource) rd).getCountries().stream())
        // .collect(Collectors.toList());
        //
        // countries.forEach(c ->
        // {
        // System.out.println(String.format("\tCountry: %s", c.getCountryCode()));
        // });

        // 2: FlatMap des Cities / OK
        List<City> cities = regionDetails
            // Collect all countries
            .stream()
            .flatMap(rd -> ((RegionDetailResource) rd).getCountries().stream())
            .collect(Collectors.toList())
            // Collect all cities
            .stream()
            .flatMap(c -> c.getCities().stream())
            .collect(Collectors.toList());
        // cities.forEach(c ->
        // {
        // System.out.println(String.format("\tCity iataCode: %s", c.getIataCode()));
        // c.getAirports().forEach(a -> System.out.println(String.format("\t\tAirport iataCode: %s", a.getIataCode())));
        // });
        // 3 : FlatMap des Airports / OK
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

        ///////////////////////////////////////////////////////////////////////
        // Maintenant on veut dégager des couples : city/airport
        // (dans l'objet AirportCity)
        ///////////////////////////////////////////////////////////////////////

        /** METHODE 1 : "classique" */
        // List<AirportCity> airportsCities = cities.forEach( {
        // AirportCity ac = null;
        // return ac
        // });
        List<AirportCity> acList = new ArrayList<>();
        for (City c : cities) {
            for (Airport a : c.getAirports()) {
                AirportCity ac = new AirportCity(a.getIataCode(), c.getIataCode());
                acList.add(ac);
            }
        }

        acList.forEach(ac ->
            {
                System.out.println(String.format("\tAirportCity: %s|%s", ac.getIataCode(), ac.getCityCode()));
            });

        /** METHODE 2 : Pure Java8/Stream/... */
        /*
         * Tentatives - START
         * Sources d'inspiration ?
         * > https://stackoverflow.com/questions/36271008/java-8-mapping-to-sub-list-entries-of-a-collection-using-streams-and-collectors
         */

        // Tentatives - END

    }

    /**
     * Class mapping Airports to Cities
     */
    private class AirportCity {

        private final String iataCode;

        public String getIataCode() {
            return iataCode;
        }

        public String getCityCode() {
            return cityCode;
        }

        private final String cityCode;

        public AirportCity(String iataCode, String cityCode) {
            this.iataCode = iataCode;
            this.cityCode = cityCode;
        }

    }

}
