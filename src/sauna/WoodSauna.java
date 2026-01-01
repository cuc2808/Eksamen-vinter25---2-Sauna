package sauna;

import java.util.ArrayList;
import java.util.TreeMap;

public class WoodSauna implements Sauna {

    String name;
    ArrayList<Integer> temperatures = new ArrayList<>();
    TreeMap<Double,Integer> hourCosts = new TreeMap<>();

    public WoodSauna(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addTemperature(int degrees) {
        temperatures.add(degrees);
    }

    @Override
    public double calculateDailyCost() {
        int dailyCost = 0;

        for (Integer temperature : temperatures) {
            if (temperature > 50) {
                dailyCost += 12;
            }
        }

        return dailyCost;
    }

    public void sortHoursByCost() {

        int hourNumber = 5;

        for (Integer temperature : temperatures) {
            double hourCost;
            if (temperature > 50) {
                hourCost = 12;
            } else {
                hourCost = 0;
            }
            hourCosts.put(hourCost, hourNumber);
            hourNumber++;
        }
    }
}