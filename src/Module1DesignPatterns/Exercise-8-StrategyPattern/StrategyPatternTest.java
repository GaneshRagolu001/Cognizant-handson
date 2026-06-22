public class StrategyPatternTest {

    public static void main(String[] args) {



        TravelContext context = new TravelContext();

        System.out.println("\n--- Case 1: Travel by Car ---");
        context.setTravelStrategy(new CarTravel());
        context.performTravel("Boston");

        System.out.println("\n--- Case 2: Switch to Flight (Runtime) ---");
        context.setTravelStrategy(new FlightTravel());
        context.performTravel("San Francisco");

        System.out.println("\n--- Case 3: Multiple Strategy Switches ---");
        context.setTravelStrategy(new CarTravel());
        context.performTravel("New York");

        context.setTravelStrategy(new FlightTravel());
        context.performTravel("London");

        System.out.println("\n--- Case 4: Different Travelers, Different Strategies ---");
        TravelContext traveler1 = new TravelContext();
        traveler1.setTravelStrategy(new CarTravel());

        TravelContext traveler2 = new TravelContext();
        traveler2.setTravelStrategy(new FlightTravel());

        System.out.print("Traveler 1: ");
        traveler1.performTravel("Chicago");

        System.out.print("Traveler 2: ");
        traveler2.performTravel("Tokyo");


    }
}
