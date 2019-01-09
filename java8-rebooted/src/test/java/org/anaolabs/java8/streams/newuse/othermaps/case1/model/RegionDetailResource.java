package org.anaolabs.java8.streams.newuse.othermaps.case1.model;

import java.util.List;

/**
 * A mapper class for GAT Resource "Region Detail"
 * 
 * @author T328469
 */
public class RegionDetailResource {

    private String iataCode;

    private String name;

    private List<Country> countries;

    ///////////////////////////////////////////////////////////////////////////
    // Getters/Setters
    ///////////////////////////////////////////////////////////////////////////

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

}
