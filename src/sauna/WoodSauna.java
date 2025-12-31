package sauna;

import java.util.ArrayList;

public class WoodSauna implements Sauna {

    String name;
    ArrayList<Integer> temperatures = new ArrayList<>();

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
            if(temperature > 50){
                dailyCost = dailyCost + 12;
            }
        }
        return dailyCost;
    }
}
