public class TravelContext {
    private TravelStrategy travelStrategy;

    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void performTravel(String destination) {
        if (travelStrategy == null) {
            System.out.println("Please select a travel strategy first.");
        } else {
            travelStrategy.travelTo(destination);
        }
    }
}
