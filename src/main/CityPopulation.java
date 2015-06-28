package main;

import java.util.HashMap;

/**
 * Created by dabluk on 28/06/15.
 */
public class CityPopulation {
    HashMap<String,Integer> cityPopulation;
    public CityPopulation(HashMap<String, Integer> data) {
        cityPopulation = new HashMap<>();
        cityPopulation.putAll(data);
    }

    public Integer getCityPopulation(String name) {
        return cityPopulation.get(name);
    }
}
