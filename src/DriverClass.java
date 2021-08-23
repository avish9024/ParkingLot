public class DriverClass {
    public static void main(String[] args) {
        ParkingLotService parkingLotService = ParkingLotService.getInstance();
        parkingLotService.initialise(4);
        Vehicle v1 = new Vehicle("abbccb", "yellow", VehicleType.TRUCK);
        Vehicle v2 = new Vehicle("abbccb", "yellow", VehicleType.TRUCK);
        Vehicle v3 = new Vehicle("abbccb", "yellow", VehicleType.TRUCK);
        Vehicle v4 = new Vehicle("abbccb", "yellow", VehicleType.TRUCK);
        Vehicle v5 = new Vehicle("abbccb", "yellow", VehicleType.TRUCK);
        System.out.println(parkingLotService.parkVehicle(v1));
        System.out.println(parkingLotService.parkVehicle(v2));
        System.out.println(parkingLotService.parkVehicle(v3));
        System.out.println(parkingLotService.parkVehicle(v4));
        parkingLotService.unParkVehicle("3 0");
        System.out.println(parkingLotService.parkVehicle(v5));
    }
}
