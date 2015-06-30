package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dabluk on 30/06/15.
 */
public class DistrictCity {
    HashMap<String,ArrayList<String>> districtCityData;
    public DistrictCity(HashMap<String, ArrayList<String>> data) {
        districtCityData = new HashMap<>();
        districtCityData.putAll(data);
    }

    public ArrayList<String> getDistrictCities(String districtName) {
        if (districtCityData.containsKey(districtName))
            return districtCityData.get(districtName);
        return new ArrayList<String>();
    }
}
