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
    private static HashMap<String,Integer> districtPopulationData;
    public static void main(String args[]){
        createStatePopulationData();
        createDistrictPopulationData();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StatePopulation statePopulation = new StatePopulation(statePopulationData);
        while(true) {
            try {
                System.out.println("Enter the State Name for getting Population");
                String stateName = br.readLine();
                int population = statePopulation.getPopulation(stateName);
                System.out.println(population);
                System.out.println("Want To check " + stateName + "District Population Press Y");
                String check = br.readLine();
                if(check.equals("Y")){
                    getDistrictPopulation();
                }
                System.out.println("Press N to exit the App or Y to continue");
                String status = br.readLine();
                if (status.equals("N"))
                    System.exit(0);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void getDistrictPopulation() {
        DistrictPopulation districtPopulation = new DistrictPopulation(districtPopulationData);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter the District Name for getting Population");
            String stateName = br.readLine();
            int population = districtPopulation.getPopulation(stateName);
            System.out.println(population);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    public  static void createDistrictPopulationData(){
        districtPopulationData = new HashMap<>();
        districtPopulationData.put("pune",1000);
        districtPopulationData.put("patna",1000);
        districtPopulationData.put("bangalore",1000);
        districtPopulationData.put("chennai",1000);
        districtPopulationData.put("bhubneshwar",1000);
    }

    private static void createStatePopulationData() {
        statePopulationData = new HashMap<>();
        statePopulationData.put("delhi",2000);
        statePopulationData.put("maharashtra",1500);
        statePopulationData.put("bihar",1200);
        statePopulationData.put("tamilnadu",1300);
        statePopulationData.put("gujrat", 2000);
    }

}
