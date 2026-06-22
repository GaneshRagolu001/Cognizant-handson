public class FactoryPatternTest {

    public static void main(String[] args) {



        VehicleFactory carFactory = new CarFactory();
        Vehicle car = carFactory.createVehicle();

        VehicleFactory bikeFactory = new BikeFactory();
        Vehicle bike = bikeFactory.createVehicle();

        VehicleFactory truckFactory = new TruckFactory();
        Vehicle truck = truckFactory.createVehicle();

        car.drive();
        bike.drive();
        truck.drive();


    }
}
