package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dabluk on 28/06/15.
 */
public class AgencyApp {
    private static HashMap<String,Integer> statePopulationData;
    private static HashMap<String,Integer> districtPopulationData;
    private static HashMap<String,ArrayList<String>> stateDisticts;
    public static void main(String args[]){
        StateDistrict stateDistrict;
        statePopulationData = CreatePopulationData.createStatePopulationData();
        districtPopulationData = CreatePopulationData.createDistrictPopulationData();
        stateDisticts = CreatePopulationData.createStateDistricts();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StatePopulation statePopulation = new StatePopulation(statePopulationData);
        while(true) {
            try {
                System.out.println("Enter the State Name for getting Population");
                String stateName = br.readLine();
                int population = statePopulation.getPopulation(stateName);
                System.out.println(population);
                System.out.println("Want To check " + stateName.toUpperCase() + " District Population Press Y");
                String check = br.readLine();
                if(check.equals("Y")){
                    getDistrictPopulation(stateName);
                }
                System.out.println("Press N to exit the App or Y to continue");
                String status = br.readLine();
                if (status.equals("N"))
                    System.exit(0);

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getDistrictPopulation(String stateName) {
        DistrictPopulation districtPopulation = new DistrictPopulation(districtPopulationData);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> districts = stateDisticts.get(stateName);
        int population = 0;
        try {
            System.out.println("Districts in " + stateName.toUpperCase() + " state");
            for(String district:districts )
                System.out.println(district.toUpperCase());
            System.out.println("Enter the District Name for getting Population");
            String districtName = br.readLine();
            if (!stateDisticts.get(stateName).contains(districtName)) {
                System.out.println("Not a valid District For given state");
                return;
            }
            population = districtPopulation.getPopulation(districtName);
            System.out.println(population);
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
