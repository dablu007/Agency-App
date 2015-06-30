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
    private static HashMap<String, Integer> cityPopulationData;
    private static HashMap<String,ArrayList<String>> stateDisticts;
    private static HashMap<String, ArrayList<String>> districtCities;

    public static void main(String args[]){
        StateDistrict stateDistrict;
        statePopulationData = CreatePopulationData.createStatePopulationData();
        districtPopulationData = CreatePopulationData.createDistrictPopulationData();
        cityPopulationData = CreatePopulationData.createCityPopulationData();
        stateDisticts = CreatePopulationData.createStateDistricts();
        districtCities = CreatePopulationData.createDistrictCities();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StatePopulation statePopulation = new StatePopulation(statePopulationData);
        while(true) {
            try {
                System.out.println("Enter the State Name for getting Population");
                String stateName = br.readLine();
                int population = statePopulation.getPopulation(stateName);
                System.out.println(population);
                System.out.println("Want To check " + stateName.toUpperCase() + " Districts Population Press Y");
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
            if (!districts.contains(districtName)) {
                System.out.println("Not a valid District For given state");
                return;
            }
            population = districtPopulation.getPopulation(districtName);
            System.out.println(population);
            System.out.println("Want To check " + districtName.toUpperCase() + " Cities Population Press Y");
            String check = br.readLine();
            if(check.equals("Y")){
                getCityPopulation(districtName);
            }
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private static void getCityPopulation(String districtName) {
        CityPopulation cityPopulation = new CityPopulation(cityPopulationData);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> cities = districtCities.get(districtName);
        try {
            System.out.println("Cities in " + districtName.toUpperCase() + " District");
            for(String city:cities )
                System.out.println(city.toUpperCase());
            System.out.println("Enter the City Name ");
            String cityName = br.readLine();
            if (!cities.contains(cityName)){
                System.out.println("Not a valid City For given District");
                return;
            }
            int population = cityPopulation.getCityPopulation(cityName);
            System.out.println(population);
            return;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
