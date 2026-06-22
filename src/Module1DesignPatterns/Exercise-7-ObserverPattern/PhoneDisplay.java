public class PhoneDisplay implements Observer {
    @Override
    public void update(String location, double temperature) {
        System.out.println("PhoneDisplay notification -> Location: " + location + ", Temp: " + temperature + "°C");
    }
}
