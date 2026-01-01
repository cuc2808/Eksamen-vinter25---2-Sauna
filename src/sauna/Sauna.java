package sauna;

public interface Sauna {
    String getName();
    void addTemperature(int degrees);
    double calculateDailyCost();
}
