package org.anaolabs.java8.streams.newuse.othermaps.case1.model;

import java.util.List;

public class Country {

    private String countryCode;

    private String countryName;

    private List<City> cities;

    public Country() {}

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}