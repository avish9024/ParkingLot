public class Vehicle {
    private String regNum;
    private String color;
    private VehicleType  type;

    public Vehicle(String regNum, String color, VehicleType type) {
        this.regNum = regNum;
        this.color = color;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
