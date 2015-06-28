package test;

import main.DistrictPopulation;
import main.StatePopulation;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by dabluk on 28/06/15.
 */
public class TestDistrictPopulation {
    DistrictPopulation districtPopulation;
    HashMap<String,Integer> dummydata;
    HashMap<String,Integer> data;
    @Before
    public void setup(){
        data = new HashMap<>();
        dummydata = new HashMap<>();

    }

    @Test
    public void testShouldGetDistrictPopulationAsNull(){
        districtPopulation = new DistrictPopulation(data);
        assertEquals(dummydata, districtPopulation.getPopulation("pune"));
    }

    @Test
    public void testShouldReturnDistrictPopulation() {
        data.put("pune",1000);
        dummydata.put("pune", 1000);
        districtPopulation = new DistrictPopulation(data);
        assertEquals(dummydata.get("pune"), districtPopulation.getPopulation("pune"));
    }


    @Test
    public void testShouldReturnPopulationOfSpecifiedDistrict() {
        data.put("pune",1000);
        data.put("mumbai",1200);
        districtPopulation = new DistrictPopulation(data);
        assertEquals(data.get("pune"), districtPopulation.getPopulation("pune"));
    }

}
