package org.anaolabs.java8.streams.newuse.othermaps.case1.model;

import java.util.List;

public class City {

    private String iataCode;

    private String name;

    private String latitude;

    private String longitude;

    private String tzRegionName;

    private String timezoneCode;

    private List<Airport> airports;

    public City() {}

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTzRegionName() {
        return tzRegionName;
    }

    public void setTzRegionName(String tzRegionName) {
        this.tzRegionName = tzRegionName;
    }

    public String getTimezoneCode() {
        return timezoneCode;
    }

    public void setTimezoneCode(String timezoneCode) {
        this.timezoneCode = timezoneCode;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}