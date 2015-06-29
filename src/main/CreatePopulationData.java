package main;

import java.util.HashMap;

/**
 * Created by dabluk on 29/06/15.
 */
public class CreatePopulationData {
    private static HashMap<String,Integer> districtPopulationData;
    private static HashMap<String,Integer> statePopulationData;
    public static HashMap createDistrictPopulationData(){
        districtPopulationData = new HashMap<>();
        districtPopulationData.put("pune",1000);
        districtPopulationData.put("patna",1000);
        districtPopulationData.put("bangalore",1000);
        districtPopulationData.put("chennai",1000);
        districtPopulationData.put("bhubneshwar",1000);
        return districtPopulationData;
    }
    public static HashMap createStatePopulationData() {
        statePopulationData = new HashMap<>();
        statePopulationData.put("delhi",2000);
        statePopulationData.put("maharashtra",1500);
        statePopulationData.put("bihar",1200);
        statePopulationData.put("tamilnadu",1300);
        statePopulationData.put("gujrat", 2000);
        return statePopulationData;
    }
}
