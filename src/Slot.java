public class Slot {
    int floor;
    int slot;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Slot(int floor, int slot) {
        this.floor = floor;
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "floor=" + floor +
                ", slot=" + slot +
                '}';
    }
}
