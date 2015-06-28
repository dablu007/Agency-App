package test;

import main.CityPopulation;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 28/06/15.
 */
public class TestCityPopulation {
    CityPopulation cityPopulation;
    HashMap<String,Integer> data;

    @Before
    public void setup(){
        data = new HashMap<>();
    }
    @Test
    public void testShouldReturnNullForCity(){
        cityPopulation = new CityPopulation(data);
        assertEquals(data.get("bangalore"),cityPopulation.getCityPopulation("bangalore"));
    }

    @Test
    public void testShouldReturnPopulationForCity() {
        data.put("bangalore",400);
        cityPopulation = new CityPopulation(data);
        assertEquals(data.get("bangalore"),cityPopulation.getCityPopulation("bangalore"));
    }
}
