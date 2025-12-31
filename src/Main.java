import sauna.SaunaManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SaunaManager manage = new SaunaManager();
        manage.loadAndCreateSaunas("src/sauna/sauna.csv");
        manage.printReport();


    }
}