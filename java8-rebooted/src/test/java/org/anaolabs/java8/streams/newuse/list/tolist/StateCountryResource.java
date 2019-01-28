package org.anaolabs.java8.streams.newuse.list.tolist;

/**
 * primary data class
 * 
 * @author t328469
 */
public class StateCountryResource {

    private String countryCode;

    private String stateCode;

    private String stateName;

    public StateCountryResource() {
        super();
    }

    public StateCountryResource(String countryCode, String stateCode, String stateName) {
        super();
        this.countryCode = countryCode;
        this.stateCode = stateCode;
        this.stateName = stateName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public String getStateName() {
        return stateName;
    }

}
