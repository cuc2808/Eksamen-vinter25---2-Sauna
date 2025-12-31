package sauna;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.*;


public class SaunaManager {

    public int i = 0;
    public static String previousName = null;
    public ArrayList<Sauna> saunas = new ArrayList<>();

    public void printReport() {

    }

    public void loadAndCreateSaunas(String fileName) {
        String filePath = fileName;


        if (filePath == null) {
            throw new RuntimeException("Filen blev ikke fundet.");
        }

        File file = new File(filePath);

        try (Scanner scannerF = new Scanner(file)) {
            scannerF.nextLine(); // spring header over

            while (scannerF.hasNextLine()) {

                String line = scannerF.nextLine();
                String[] f = line.split(",");

                int degreeInSauna = Integer.parseInt(f[1]);
                String saunaName = f[2];
                String saunaType = f[3];

                if (saunas.isEmpty()) {
                    if (saunaType.equals("wood")) {
                        saunas.add(new WoodSauna(saunaName));
                        System.out.println("Sauna created" + saunaName);
                    } else if (saunaType.equals("electric")) {
                        saunas.add(new ElectricSauna(saunaName));
                    }
                    previousName = saunaName;
                } else if (!saunaName.equals(previousName)) {
                    if (saunaType.equals("wood")) {
                        saunas.add(new WoodSauna(saunaName));
                        System.out.println("WSauna created" + saunaName);
                    } else if (saunaType.equals("electric")) {
                        saunas.add(new ElectricSauna(saunaName));
                        System.out.println("ESauna created" + saunaName);
                    }
                    previousName = saunaName;
                } else if(saunaName.equals(previousName)){
                    for (Sauna sauna : saunas) {
                        sauna.addTemperature(degreeInSauna);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public double getAverageCost(String type) {
        double totalCost = 0;
        double ammountOfSaunas = 0;
        double averageCost = 0;

        if (type == "wood") {
            for (Sauna sauna : saunas) {
                if (sauna instanceof WoodSauna) {
                    totalCost = totalCost + sauna.calculateDailyCost();
                    ammountOfSaunas++;
                    System.out.println("wood");
                }
            }
        } else if (type == "electric") {
            for (Sauna sauna : saunas) {
                if (sauna instanceof ElectricSauna) {
                    totalCost = totalCost + sauna.calculateDailyCost();
                    ammountOfSaunas++;
                    System.out.println("electric");
                }
            }

        }
        averageCost = totalCost/ammountOfSaunas;

        return averageCost;
    }

    public Sauna getMostExpensive() {
        return null;
    }

    public Sauna getCheapest() {
        return null;
    }

}
