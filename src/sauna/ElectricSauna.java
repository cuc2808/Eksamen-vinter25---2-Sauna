package sauna;

import java.util.ArrayList;

public class ElectricSauna implements Sauna {

    String name;
    ArrayList<Integer> temperatures = new ArrayList<>();

    public ElectricSauna(String name) {
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
                dailyCost += 8;

                if (temperature > 70) {
                    dailyCost += (temperature - 70) * 2;
                }
            }
        }

        return dailyCost;
    }
}

