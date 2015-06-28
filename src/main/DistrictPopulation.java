package main;

import java.util.HashMap;

/**
 * Created by dabluk on 28/06/15.
 */
public class DistrictPopulation {
    private HashMap<String,Integer> districtpopulation;

    public DistrictPopulation(HashMap<String, Integer> data) {
        districtpopulation = new HashMap<>();
        districtpopulation.putAll(data);
    }

    public Integer getPopulation(String name) {
        return this.districtpopulation.get(name);
    }
}
