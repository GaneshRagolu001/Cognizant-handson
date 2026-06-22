public class CarTravel implements TravelStrategy {
    @Override
    public void travelTo(String destination) {
        System.out.println("Traveling to " + destination + " by Car. Fast and flexible route!");
    }
}
