package test;

import main.StateDistrict;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 28/06/15.
 */
public class TestStateDistrict {
    StateDistrict stateDistrict;
    HashMap<String,ArrayList<String>> stateDistrictData;
    ArrayList<String> districts;
    ArrayList<String> anotherDistricts;
    @Before
    public void setup(){
        districts = new ArrayList<>();
        anotherDistricts = new ArrayList<>();
        stateDistrictData = new HashMap<>();
        districts.add("thane");
        districts.add("pune");
        anotherDistricts.add("patna");
        anotherDistricts.add("samastipur");
    }
    @Test
    public void testShouldReturnDistrictNull(){
        stateDistrictData.put("maharashtra", new ArrayList<String>());
        stateDistrict = new StateDistrict(stateDistrictData);
        assertEquals(null,stateDistrict.getDistrictsForState("maharashtra"));

    }

    @Test
    public void testShouldReturnDistrictForState() {
        stateDistrictData.put("maharashtra",districts);
        stateDistrictData.put("bihar",anotherDistricts);
        stateDistrict = new StateDistrict(stateDistrictData);
        assertEquals(anotherDistricts, stateDistrict.getDistrictsForState("bihar"));
    }

    @Test
    public void testShouldNotReturnNullWhenStateNotPresent() {
        stateDistrictData.put("maharashtra",districts);
        stateDistrict = new StateDistrict(stateDistrictData);
        assertEquals(new ArrayList<String>(), stateDistrict.getDistrictsForState("karnataka"));
    }
}
