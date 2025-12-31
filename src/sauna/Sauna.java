package sauna;

public abstract interface Sauna {
    String getName();
    void addTemperature(int degrees);
    double calculateDailyCost();
}
