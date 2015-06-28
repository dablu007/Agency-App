package main;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dabluk on 28/06/15.
 */
public class StatePopulation {
    private HashMap<String,Integer> populationData;

    public StatePopulation(HashMap<String, Integer> data) {
        populationData = new HashMap<>();
        populationData.putAll(data);
    }

    public Integer getPopulation(String name) {
        return this.populationData.get(name);
    }
}
