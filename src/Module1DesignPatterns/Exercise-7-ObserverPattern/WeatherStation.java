import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
    private List<Observer> observers;
    private String location;
    private double temperature;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(location, temperature);
        }
    }

    public void setMeasurements(String location, double temperature) {
        this.location = location;
        this.temperature = temperature;
        System.out.println("WeatherStation Update: " + location + " temperature is now " + temperature + "°C");
        notifyObservers();
    }
}
