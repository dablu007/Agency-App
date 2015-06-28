package main;

import java.util.HashMap;

/**
 * Created by dabluk on 28/06/15.
 */
public class StatePopulation {
    private HashMap<String,Integer> statePopulation;

    public StatePopulation(HashMap<String, Integer> data) {
        statePopulation = new HashMap<>();
        statePopulation.putAll(data);
    }

    public Integer getPopulation(String name) {
        return this.statePopulation.get(name);
    }
}
