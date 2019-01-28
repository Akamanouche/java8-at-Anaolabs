package org.anaolabs.java8.streams.newuse.list.tolist;

import java.util.List;

/**
 * Classe en sortie
 * 
 * @author t328469
 */
public class StatesForCountry {

    private String countryCode;

    private List<State> states;

    public StatesForCountry(String countryCode, List<State> states) {
        super();
        this.countryCode = countryCode;
        this.states = states;
    }

    public StatesForCountry() {
        super();
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    /**
     * Inner class for STATES
     *
     * @author t328469
     */
    public static class State {

        private String stateCode;

        private String stateName;

        public State() {
            super();
        }

        public State(String stateCode, String stateName) {
            super();
            this.stateCode = stateCode;
            this.stateName = stateName;
        }

        public String getStateCode() {
            return stateCode;
        }

        public void setStateCode(String stateCode) {
            this.stateCode = stateCode;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }
    }
}
