public abstract class VehicleFactory {
    public abstract Vehicle createVehicle();

    public void startJourney() {
        Vehicle vehicle = createVehicle();
        vehicle.drive();
    }
}
