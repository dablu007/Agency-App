package test;

import main.StatePopulation;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Created by dabluk on 28/06/15.
 */
public class TestStatePopulation {

    StatePopulation statePopulation;
    HashMap<String,Integer> dummydata;
    HashMap<String,Integer> data;
    @Before
    public void setup(){
        data = new HashMap<>();
        dummydata = new HashMap<>();

    }
    @Test
    public void testShouldGetStatePopulationAsNull(){
        statePopulation = new StatePopulation(data);
        assertEquals(dummydata, statePopulation.getPopulation("tamilnadu"));
    }

    @Test
    public void testShouldReturnStatePopulation() {
        data.put("maharashtra",1000);
        statePopulation = new StatePopulation(data);
        dummydata.put("maharashtra", 1000);
        assertEquals(dummydata, statePopulation.getPopulation("maharashtra"));
    }


    @Test
    public void testShouldReturnPopulationOfSpecifiedState() {
        data.put("maharashtra",1000);
        data.put("karnataka",1200);
        data.put("tamilnadu",900);
        statePopulation = new StatePopulation(data);
        assertEquals(data.get("tamilnadu"), statePopulation.getPopulation("tamilnadu"));
    }
}
