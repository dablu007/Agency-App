package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by dabluk on 28/06/15.
 */
public class AgencyApp {
    private static HashMap<String,Integer> statePopulationData;
    public static void main(String args[]){
        createStatePopulationData();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StatePopulation statePopulation = new StatePopulation(statePopulationData);
        while(true) {

            try {
                System.out.println("Enter the State Name for getting Population");
                String stateName = br.readLine();
                int population = statePopulation.getPopulation(stateName);
                System.out.println(population);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createStatePopulationData() {
        statePopulationData = new HashMap<>();
        statePopulationData.put("delhi",2000);
        statePopulationData.put("maharashtra",1500);
        statePopulationData.put("bihar",1200);
        statePopulationData.put("tamilnadu",1300);
        statePopulationData.put("gujrat",2000);
    }
}
