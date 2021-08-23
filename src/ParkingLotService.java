public class ParkingLotService {
    public static ParkingLotService parkingLotService = null;
    ParkingLotDao parkingLotDao = ParkingLotDao.getInstance();
    private int size = 0;
    private int nearestTruckSlot = 0;
    private int nearestCarSlot = 1;
    private int nearestBikeSlot = 3;
    private int nearestTruckFloor = 0;
    private int nearestCarFloor = 0;
    private int nearestBikeFloor = 0;

    private ParkingLotService() {

    }

    public static ParkingLotService getInstance() {
        if (parkingLotService == null) parkingLotService = new ParkingLotService();
        return parkingLotService;
    }

    public void initialise(int floor) {
        parkingLotDao.initialise(floor);
        size = floor;
        System.out.println("Parking lot initialised with " + floor + " floors and 6 slots on each floor");
    }

    public String parkVehicle(Vehicle vehicle) {
        String ticketId = "";
        VehicleType type = vehicle.getType();
        switch (type) {
            case TRUCK: ticketId = getSlotForTruck(vehicle); break;
            case CAR: ticketId = getSlotForCar(vehicle); break;
            case BIKE: ticketId = getSlotForBike(vehicle); break;
            default: throw new UnsupportedOperationException("No slot available for this type of vehicle");
        }
        return ticketId;
    }

    private String getSlotForTruck(Vehicle vehicle) {
        if (nearestTruckFloor >= size && nearestTruckSlot > 1) {
            System.out.println("No slots available, all truck slots are occupied");
            return "";
        }
        parkingLotDao.fillSlot(vehicle, nearestTruckFloor, nearestTruckSlot);
        String ticketId = IdUtil.getTicketId(nearestTruckFloor, nearestTruckSlot);
        nearestTruckSlot++;
        if (nearestTruckSlot > 0) {
            nearestTruckFloor++;
            nearestTruckSlot = 0;
        }
        return ticketId;
    }

    private String getSlotForCar(Vehicle vehicle) {
        if (nearestCarFloor > size && nearestCarSlot > 2) {
            System.out.println("No slots available, all car slots are occupied");
            return "";
        }
        parkingLotDao.fillSlot(vehicle, nearestCarFloor, nearestCarSlot);
        String ticketId = IdUtil.getTicketId(nearestCarFloor, nearestCarSlot);
        nearestCarSlot++;
        if (nearestCarSlot >= 2) {
            nearestCarFloor++;
            nearestCarSlot = 1;
        }
        return ticketId;
    }

    private String getSlotForBike(Vehicle vehicle) {
        if (nearestBikeFloor > size && nearestBikeSlot > 5) {
            System.out.println("No slots available, all car slots are occupied");
            return "";
        }
        parkingLotDao.fillSlot(vehicle, nearestBikeFloor, nearestBikeSlot);
        String ticketid = IdUtil.getTicketId(nearestBikeFloor, nearestBikeSlot);
        nearestBikeSlot++;
        if (nearestCarSlot >= 5) {
            nearestBikeFloor++;
            nearestBikeSlot = 3;
        }
        return ticketid;
    }

    public void unParkVehicle(String id) {
        Slot slot = IdUtil.getSlot(id);
        System.out.println(size);
        if (slot.getSlot() < 0 || slot.getFloor() < 0 || slot.getFloor() >= size || slot.getSlot() >= 6) {
            throw new UnsupportedOperationException("Invalid ticket id");
        }
        if (slot.getSlot() < 1) {
            if (nearestTruckFloor > 0) nearestTruckFloor--;
            nearestTruckSlot = 0;
        } if (slot.getSlot() > 0 && slot.getSlot() < 3) {
            nearestCarSlot--;
            if (nearestCarSlot < 1) {
                if (nearestCarFloor > 0) nearestCarFloor--;
            }
        } if (slot.getSlot() > 2 && slot.getSlot() < 6) {
            nearestBikeSlot--;
            if (nearestBikeSlot < 3) {
                if (nearestBikeFloor > 0) nearestBikeFloor--;
            }
        }
        parkingLotDao.unFillSlot(slot.getFloor(), slot.getSlot());
        System.out.println("Vehicle left");
    }
}
