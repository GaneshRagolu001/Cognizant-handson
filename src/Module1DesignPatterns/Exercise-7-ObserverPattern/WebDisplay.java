public class WebDisplay implements Observer {
    @Override
    public void update(String location, double temperature) {
        System.out.println("WebDisplay dashboard -> Location: " + location + ", Temp: " + temperature + "°C");
    }
}
