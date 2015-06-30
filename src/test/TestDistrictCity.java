package test;

import main.DistrictCity;
import main.StateDistrict;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 30/06/15.
 */
public class TestDistrictCity {
    DistrictCity districtCity;
    HashMap<String,ArrayList<String>> districtCityData;
    ArrayList<String> cities;
    ArrayList<String> diffrentCities;
    @Before
    public void setup(){
        cities = new ArrayList<>();
        diffrentCities = new ArrayList<>();
        districtCityData = new HashMap<>();
        cities.add("ramgadh");
        cities.add("rajrappa");
        cities.add("gola");
    }
    @Test
    public void testShouldReturnDistrictNull(){
        districtCityData.put("ranchi",new ArrayList<String>());
        districtCity = new DistrictCity(districtCityData);
        assertEquals(null,districtCity.getDistrictCities("ranchi"));

    }

    @Test
    public void testShouldReturnDistrictForState() {
        districtCityData.put("ranchi",cities);
        districtCity = new DistrictCity(districtCityData);
        assertEquals(cities, districtCity.getDistrictCities("ranchi"));
    }

    @Test
    public void testShouldNotReturnNullWhenStateNotPresent() {
        districtCity = new DistrictCity(districtCityData);
        assertEquals(new ArrayList<String>(), districtCity.getDistrictCities("pune"));
    }
}
