public class ObserverPatternTest {

    public static void main(String[] args) {



        WeatherStation weatherStation = new WeatherStation();

        Observer phone = new PhoneDisplay();
        Observer web = new WebDisplay();

        System.out.println("\n--- Registering Observers ---");
        weatherStation.registerObserver(phone);
        System.out.println("PhoneDisplay registered.");
        weatherStation.registerObserver(web);
        System.out.println("WebDisplay registered.");

        System.out.println("\n--- Weather Update 1 ---");
        weatherStation.setMeasurements("New York", 28.5);

        System.out.println("\n--- Weather Update 2 ---");
        weatherStation.setMeasurements("London", 18.0);

        System.out.println("\n--- Removing Web Observer ---");
        weatherStation.removeObserver(web);
        System.out.println("WebDisplay removed from observers.");

        System.out.println("\n--- Weather Update 3 (WebDisplay removed) ---");
        weatherStation.setMeasurements("New York", 30.2);


    }
}
