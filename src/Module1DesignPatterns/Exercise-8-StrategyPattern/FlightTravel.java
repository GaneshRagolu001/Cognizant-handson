public class FlightTravel implements TravelStrategy {
    @Override
    public void travelTo(String destination) {
        System.out.println("Traveling to " + destination + " by Flight. Fastest way across long distance!");
    }
}
