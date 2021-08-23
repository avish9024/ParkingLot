public class ParkingLotDao {
    public static ParkingLotDao parkingLotManager = null;
    private Vehicle[][] parkingLot;
    private boolean isInitialised = false;

    private ParkingLotDao() {

    }

    public static ParkingLotDao getInstance() {
        if (parkingLotManager == null) parkingLotManager = new ParkingLotDao();
        return parkingLotManager;
    }

    public void initialise(int size) {
        if (isInitialised) {
            System.out.println("Parking lot already created");
            return;
        }
        isInitialised = true;
        parkingLot = new Vehicle[size][6];
    }

    public void fillSlot(Vehicle vehicle, int floor, int slot) {
        parkingLot[floor][slot] = vehicle;
    }

    public void unFillSlot(int floor, int slot) {
        parkingLot[floor][slot] = null;
    }

}
