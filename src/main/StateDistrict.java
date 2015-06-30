package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dabluk on 28/06/15.
 */
public class StateDistrict {
    HashMap<String,ArrayList<String>> stateDistrictData;
    public StateDistrict(HashMap<String, ArrayList<String>> data) {
        stateDistrictData = new HashMap<>();
        stateDistrictData.putAll(data);
    }

    public ArrayList<String> getDistrictsForState(String name) {
        if (stateDistrictData.containsKey(name))
            return stateDistrictData.get(name);
        return new ArrayList<>();
    }
}
